const db = require('../../../db')
const DeleteStatus = require("../model/deleteStatus");
const AddStatus = require("../model/addStatus");

class DeliveriesDao {

    addDelivery(delivery) {
        const returnDelivery = {};

        const sql = 'INSERT INTO delivery (date, note, suppliersId, userId) VALUES ?';
        const sqlData = [
            [
                delivery.date,
                delivery.note,
                delivery.suppliersId,
                delivery.userId
            ]
        ];

        return new Promise(async (resolve) => {
            db.query(sql, [sqlData], function (err, result) {
                if (err) {
                    returnDelivery.status = AddStatus.ERROR;
                    resolve(returnDelivery);
                }
                returnDelivery.deliveryId = result.insertId;
                returnDelivery.status = AddStatus.OK
                resolve(returnDelivery);
            })
        })
    }

    getDelivery(date, suppliersId) {
        const sql = 'SELECT * FROM delivery WHERE date = ? AND suppliersId = ?';

        return new Promise((resolve) => {
            db.query(sql, [date, suppliersId], function (err, result) {
                resolve(result);
            })
        })
    }

    deleteDelivery(deliveryId) {
        const delId= deliveryId;
        const sql = 'DELETE receipts_log, receipts, delivery FROM receipts_log \n' +
            'RIGHT JOIN receipts ON receipts.receiptsLogId = receipts_log.id\n' +
            'RIGHT JOIN delivery ON delivery.id = receipts.deliveryId\n' +
            'WHERE delivery.id = ? ';

        return new Promise((resolve) => {
            db.query(sql, [deliveryId], function (err, result) {
                if (err) {
                    resolve(DeleteStatus.ERROR)
                }
                resolve(DeleteStatus.OK);
            })
        })
    }

    addReceipts(receipt) {
        return new Promise((resolve) => {
            db.beginTransaction(function (err) {
                if (err) {
                    resolve(AddStatus.ERROR);
                }
                const addReceiptsLogSql = 'INSERT INTO receipts_log (quantity, quantityRemains, date, materialsId, receiptsReasonId, userId) VALUES ?';
                const addedReceiptsLog = [
                    [
                        receipt.quantity,
                        receipt.quantityRemains,
                        receipt.date,
                        receipt.materialsId,
                        receipt.receiptsReasonId,
                        receipt.userId
                    ]
                ];
                db.query(addReceiptsLogSql, [addedReceiptsLog], function (err, result) {
                    if (err) {
                        db.rollback(function () {
                            resolve(AddStatus.ERROR);
                        });
                    }
                    const addReceiptsSql = 'INSERT INTO receipts (receiptsLogId, deliveryId) VALUES ?';
                    const addedReceipt = [
                        [
                            result.insertId,
                            receipt.deliveryId
                        ]
                    ]
                    db.query(addReceiptsSql, [addedReceipt], function (err, result) {
                        if (err) {
                            db.rollback(function () {
                                resolve(AddStatus.ERROR);
                            });
                        }
                        db.commit(function (err) {
                            if (err) {
                                db.rollback(function () {
                                    resolve(AddStatus.ERROR);
                                });
                            }
                            resolve(AddStatus.OK);
                        });
                    });
                });
            });
        });
    };

    getReceiptMaterial(receiptId) {
        const sql = "SELECT * FROM receipts \n " +
            "INNER JOIN receipts_log ON receipts.receiptsLogId = receipts_log.id \n" +
            "WHERE receipts.id = ?";

        return new Promise((resolve) => {
            db.query(sql, [receiptId], function (err, data) {
                resolve(data);
            })
        })
    }

    deleteReceipt(receiptId) {
        const sql = 'DELETE receipts_log, receipts FROM receipts_log\n' +
            'RIGHT JOIN receipts ON receipts.receiptsLogId = receipts_log.id\n' +
            'WHERE receipts.id = ?';

        return new Promise((resolve) => {
            db.query(sql, [receiptId], function (err, data) {
                if (err) {
                    resolve(DeleteStatus.ERROR);
                }
                resolve(DeleteStatus.OK);
            })
        })
    }
}

module.exports = new DeliveriesDao();