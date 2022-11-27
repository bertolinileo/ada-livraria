package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Comprador {
    public String nome;
    public String rg;
    public String cpf;
    public String dataNascimento;

    public Comprador(String nome, String rg, String cpf, String dataNascimento) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public Integer getIdade() {
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Date dataNascimento = null;

        try {
            dataNascimento = sdf.parse(this.dataNascimento);

        } catch (Exception e) {}

        Calendar dateOfBirth = new GregorianCalendar();

        dateOfBirth.setTime(dataNascimento);

        Calendar today = Calendar.getInstance();

        int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

        dateOfBirth.add(Calendar.YEAR, age);

        if (today.before(dateOfBirth)) {
            age--;
        }

        return age;
    }
}
