const deliveriesService = require("../service/deliveriesService");
const AddStatus = require("../model/addStatus");
const DeleteStatus = require("../model/deleteStatus");

test('test getting empty receipt', async () => {
    expect((await deliveriesService.getReceiptMaterial(-1)).length).toBeLessThan(1);
});

test('test add delivery', async () => {
    const delivery = {
        date: "2021-04-03 10:30:00",
        note: "test",
        suppliersId: -1,
        userId: 1
    }
    expect((await deliveriesService.addDelivery(delivery)).status).toBe(AddStatus.OK);
});

test('test add duplicate delivery and delete', async () => {
    const delivery = {
        date: "2021-04-03 10:30:00",
        note: "test",
        suppliersId: -1,
        userId: 1
    }
    const addedDelivery = await deliveriesService.addDelivery(delivery);
    expect(addedDelivery.status).toBe(AddStatus.DUPLICATE);
    expect(await deliveriesService.deleteDelivery(addedDelivery.deliveryId)).toBe(DeleteStatus.OK);
});


