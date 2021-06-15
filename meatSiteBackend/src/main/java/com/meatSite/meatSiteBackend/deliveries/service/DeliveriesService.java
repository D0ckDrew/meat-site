package com.meatSite.meatSiteBackend.deliveries.service;

import com.meatSite.meatSiteBackend.database.model.DeliveryModel;
import com.meatSite.meatSiteBackend.database.model.MaterialReceiptsLogModel;
import com.meatSite.meatSiteBackend.database.model.ReceiptsModel;
import com.meatSite.meatSiteBackend.database.model.SuppliersModel;
import com.meatSite.meatSiteBackend.database.repository.DeliveryRepository;
import com.meatSite.meatSiteBackend.database.repository.ReceiptsRepository;
import com.meatSite.meatSiteBackend.database.repository.SuppliersRepository;
import com.meatSite.meatSiteBackend.materialWarehouse.model.ReceiptElementModel;
import com.meatSite.meatSiteBackend.materialWarehouse.service.MaterialWarehouseService;
import com.meatSite.meatSiteBackend.response.Response;
import com.meatSite.meatSiteBackend.response.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class DeliveriesService {

    private final DeliveryRepository deliveryRepository;
    private final SuppliersRepository suppliersRepository;
    private final ReceiptsRepository receiptsRepository;
    private final MaterialWarehouseService materialWarehouseService;

    @Autowired
    public DeliveriesService(DeliveryRepository deliveryRepository, SuppliersRepository suppliersRepository, ReceiptsRepository receiptsRepository, MaterialWarehouseService materialWarehouseService) {
        this.deliveryRepository = deliveryRepository;
        this.suppliersRepository = suppliersRepository;
        this.receiptsRepository = receiptsRepository;
        this.materialWarehouseService = materialWarehouseService;
    }

    public List<DeliveryModel> get() {
        return deliveryRepository.get();
    }

    public List<SuppliersModel> getSuppliers() {
        return suppliersRepository.get();
    }


    public Response addDelivery(int suppliersId, int timestamp, String note) {

        if (suppliersId < 0 || timestamp <= 0) {
            return ResponseStatus.VALIDATION_ERROR.getResponse();
        }

        DeliveryModel delivery = new DeliveryModel();
        delivery.setSuppliersId(suppliersId);
        delivery.setDate(new Timestamp(timestamp * 1000L));
        delivery.setUserId(1);

        deliveryRepository.save(delivery);
        return ResponseStatus.SUCCESSFULLY.getResponse();
    }

    @Transactional
    public Response addEntrance(int deliveryId, int receiptsReasonId, List<ReceiptElementModel> receiptElements) {

        if (deliveryId < 0 || receiptElements == null || receiptElements.size() <= 0) {
            return ResponseStatus.VALIDATION_ERROR.getResponse();
        }

        for (ReceiptElementModel receiptElement : receiptElements) {
            MaterialReceiptsLogModel materialReceiptsLogModel = new MaterialReceiptsLogModel();
            ReceiptsModel receiptsModel = new ReceiptsModel();

            MaterialReceiptsLogModel oldMaterialReceiptsLog = null;
            List<ReceiptsModel> receipts = receiptsRepository.getAllByDeliveryIdAndMaterialReceiptsLogById_MaterialId(deliveryId, receiptElement.getMaterialId());
            if (receipts.size() > 0) {
                oldMaterialReceiptsLog = receipts.get(0).getMaterialReceiptsLogById();
                materialReceiptsLogModel.setId(oldMaterialReceiptsLog.getId());
                receiptsModel.setId(receipts.get(0).getId());
            }

            materialReceiptsLogModel.setDate(new Timestamp(new Date().getTime()));
            materialReceiptsLogModel.setMaterialId(receiptElement.getMaterialId());
            materialReceiptsLogModel.setQuantity(receiptElement.getCount());
            materialReceiptsLogModel.setMaterialReceiptsReasonId(receiptsReasonId);
            materialReceiptsLogModel.setUserId(1);
            Long mtRcLgId = materialWarehouseService.addMaterialFromWarehouseLog(materialReceiptsLogModel, oldMaterialReceiptsLog);

            receiptsModel.setDeliveryId(deliveryId);
            receiptsModel.setMaterialReceiptsLogId(mtRcLgId.intValue());

            receiptsRepository.save(receiptsModel);
        }

        return ResponseStatus.SUCCESSFULLY.getResponse();
    }

    public List<ReceiptsModel> getReceiptsByDeliveryId(Integer deliveryId) {
        return receiptsRepository.getAllByDeliveryId(deliveryId);
    }
}
