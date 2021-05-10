const deliveriesDao = require("../dao/deliveriesDao");

const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken')
const DeleteStatus = require("../model/deleteStatus");
const AddStatus = require("../model/addStatus");

class DeliveriesService {
    async addDelivery(delivery) {
        const deliv = await deliveriesDao.getDelivery(delivery.date, delivery.suppliersId);
        if (deliv && deliv.length) {
            return Promise.resolve({
                deliveryId: deliv[0].id,
                status: AddStatus.DUPLICATE});
        } else {
            return await deliveriesDao.addDelivery(delivery);
        }
    }

    async deleteDelivery(deliveryId) {
        return await deliveriesDao.deleteDelivery(deliveryId);
    }

    async deleteDeliveryFromParams(date, suppliersId) {
        const delivery = await deliveriesDao.getDelivery(date, suppliersId)
        if (delivery && delivery.length) {
            return await deliveriesDao.deleteDelivery(delivery.id);
        } else {
            return Promise.resolve(DeleteStatus.NOT_DELETED_OBJECT);
        }
    }

    async addReceipts(receipt) {
        const addStatus = await deliveriesDao.addReceipts(receipt);
        return {status: addStatus};
    }

    async getReceiptMaterial(receiptId) {
        return await deliveriesDao.getReceiptMaterial(receiptId)
    }

    async getDeliveryMaterials(deliveryId) {
        return await deliveriesDao.getDeliveryMaterials(deliveryId)
    }

    async deleteReceipt(receiptId) {
        return await deliveriesDao.deleteReceipt(receiptId)
    }
}

module.exports = new DeliveriesService();
