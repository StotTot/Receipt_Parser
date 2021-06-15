package dev.debride.receiptparser.models;

public class Receipt {
    private String data;

    private Double total;

    private Double taxesPaid;

    public Receipt(String data) {
        this.data = data;
    }

    public Receipt() {

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

    @Override
    public String toString() {
        return "Receipt{" +
                "data='" + data + '\'' +
                ", total=" + total +
                ", taxesPaid=" + taxesPaid +
                '}';
    }
}
