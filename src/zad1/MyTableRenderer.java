package zad1;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

class MyTableRenderer extends DefaultTableCellRenderer {
    String CountryFileName;
    public MyTableRenderer(String CountryFileName){
        this.CountryFileName = CountryFileName;
        this.setPreferredSize(new Dimension(20,20));
    }


    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        MyTableModel mod = new MyTableModel(CountryFileName);
        JLabel jl = ((JLabel) component);
        if (Integer.parseInt(String.valueOf(value)) <20000000)
            jl.setForeground(new Color(0,0,0));

        if (Integer.parseInt(String.valueOf(value)) > 20000000)
            jl.setForeground(new Color(255,0,0));

        setHorizontalAlignment(SwingConstants.RIGHT);
        return this;
    }
}
