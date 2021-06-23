package dev.debride.receiptparser.models;

import javax.persistence.*;

@Entity
@Table(name = "\"receipts\"")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "receipt_id")
    private Integer id;
    @Column(name = "data", length = 10000)
    private String data;
    @Column(name = "total")
    private Double total;
    @Column(name = "taxes")
    private Double taxesPaid;
    @Column(name = "url", length = 1024)
    private String url;
    @Column(name = "date")
    private Long date;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", total=" + total +
                ", taxesPaid=" + taxesPaid +
                ", url='" + url + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
