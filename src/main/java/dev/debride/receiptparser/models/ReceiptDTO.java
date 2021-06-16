package dev.debride.receiptparser.models;

public class ReceiptDTO {
    private String data;

    private Double total;

    private Double taxesPaid;

    private String url;

    public ReceiptDTO(Receipt receipt) {
        this.data = receipt.getData();
        this.total = receipt.getTotal();
        this.taxesPaid = receipt.getTaxesPaid();
        this.url = receipt.getUrl();
    }

    public ReceiptDTO() {

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getTaxesPaid() {
        return taxesPaid;
    }

    public void setTaxesPaid(Double taxesPaid) {
        this.taxesPaid = taxesPaid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ReceiptDTO{" +
                "data='" + data + '\'' +
                ", total=" + total +
                ", taxesPaid=" + taxesPaid +
                ", url='" + url + '\'' +
                '}';
    }
}
