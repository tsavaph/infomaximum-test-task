package ru.infomaximum.object;

import com.opencsv.bean.CsvBindByName;

import java.util.Objects;

public class ParsingFileObject {

    @CsvBindByName
    private String group;

    @CsvBindByName
    private String type;

    @CsvBindByName
    private long number;

    @CsvBindByName
    private long weight;

    public ParsingFileObject() {
    }

    public ParsingFileObject(String group, String type, long number, long weight) {
        this.group = group;
        this.type = type;
        this.number = number;
        this.weight = weight;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParsingFileObject that = (ParsingFileObject) o;
        return number == that.number && weight == that.weight && group.equals(that.group) && type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, type, number, weight);
    }
}