package com.engsoft2.currencyreport;

// Classe simples apenas para ler a resposta do outro serviço e manipular o outpiut json
public class CurrencyExchangeDto {
    private String from;
    private String to;
    private double conversionMultiple; // É aqui que vem o preço
    
    // Getters e Setters necessários
    public double getConversionMultiple() { return conversionMultiple; }
    public void setConversionMultiple(double conversionMultiple) { this.conversionMultiple = conversionMultiple; }
    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }
    public String getTo() { return to; }
    public void setTo(String to) { this.to = to; }
}