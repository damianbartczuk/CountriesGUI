package zad1;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class MyTableRendererSecond extends DefaultTableCellRenderer {

    private String CountryFileName;
    public MyTableRendererSecond(String CountryFileName){
        this.CountryFileName = CountryFileName;
        this.setPreferredSize(new Dimension(20,20));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        MyTableModel mod = new MyTableModel(CountryFileName);
        JLabel jl = ((JLabel) component);
        String path;
        jl.setText(null);
        path = mod.getvData().get(row+1).toString().substring(mod.getvData().get(row+1).toString().length() - 18, mod.getvData().get(row+1).toString().length() - 1);
        jl.setIcon(new ImageIcon(path));
        setHorizontalAlignment(SwingConstants.CENTER);
        return this;
    }




}
