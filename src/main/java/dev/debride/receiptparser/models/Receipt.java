package dev.debride.receiptparser.models;

import javax.persistence.*;

@Entity
@Table(name = "\"receipts\"")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receipt_id")
    private Integer id;
    @Column(name = "data")
    private String data;
    @Column(name = "total")
    private Double total;
    @Column(name = "taxes")
    private Double taxesPaid;
    @Column(name = "url")
    private String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "data='" + data + '\'' +
                ", total=" + total +
                ", taxesPaid=" + taxesPaid +
                ", url='" + url + '\'' +
                '}';
    }
}
