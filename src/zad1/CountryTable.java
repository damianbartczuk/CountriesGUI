package zad1;

import javax.swing.*;

class CountryTable{
    private static  String CountryFileName;

    public CountryTable(String CountryFileName){
        this.CountryFileName = CountryFileName;
    }

    public static JTable create(){
        JTable t = new JTable();
        MyTableModel mtm = new MyTableModel(CountryFileName);
        MyTableRenderer mtr = new MyTableRenderer(CountryFileName);
        MyTableRendererSecond mtr2 = new MyTableRendererSecond(CountryFileName);
        t.setDefaultRenderer(Integer.class, mtr);
        t.setDefaultRenderer(Flag.class, mtr2);
        t.setModel(mtm);
        return t;
    }

}