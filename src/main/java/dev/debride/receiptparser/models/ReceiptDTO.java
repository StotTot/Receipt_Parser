package dev.debride.receiptparser.models;

public class ReceiptDTO {

    private Integer id;

    private String data;

    private Double total;

    private Double taxesPaid;

    private String url;

    private Long date;

    public ReceiptDTO(Receipt receipt) {
        this.id = receipt.getId();
        this.data = receipt.getData();
        this.total = receipt.getTotal();
        this.taxesPaid = receipt.getTaxesPaid();
        this.url = receipt.getUrl();
        this.date = receipt.getDate();
    }

    public ReceiptDTO() {

    }

    @Override
    public String toString() {
        return "ReceiptDTO{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", total=" + total +
                ", taxesPaid=" + taxesPaid +
                ", url='" + url + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

}
