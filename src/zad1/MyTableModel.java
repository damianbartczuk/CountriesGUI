package zad1;

import javax.swing.table.AbstractTableModel;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

class MyTableModel extends AbstractTableModel {

    private Vector<String> v1;
    private Vector<Vector> vData;

    public Vector<String> getV1() {
        return v1;
    }

    public Vector<Vector> getvData() {
        return vData;
    }

    public MyTableModel(String CountryFileName){
        v1 = new Vector<>();
        vData = new Vector<>();

        String line = "";
        FileReader plikWe = null;
        try {
            int idx = 0;
            plikWe = new FileReader(CountryFileName);
            int c;
            while ((c = plikWe.read()) != -1) {
                if(c > 32) {
                    line+=(char)c;
                }
                else{
                    if(line.equals(""))
                        continue;
                    v1.add(line);
                    line = "";
                    idx++;
                    if ( idx%4==0 ){
                        vData.add(v1);
                        v1 = new Vector<>();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            v1.add(line);
            vData.add(v1);
            if (plikWe != null) {
                try {
                    plikWe.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public int getRowCount() {
        return vData.size()-1;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MyTableRendererSecond ren = new MyTableRendererSecond("data/countries.txt");
        for (int i = 0; i <vData.size()-1 ; i++) {
                return vData.get(rowIndex+1).get(columnIndex);
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 2) {
            return Integer.class;
        }
        if (columnIndex == 3) {
            return Flag.class;
        }
        return String.class;
    }

    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0:
                return vData.get(0).get(0).toString();
            case 1:
                return vData.get(0).get(1).toString();
            case 2:
                return vData.get(0).get(2).toString();
            case 3:
                return vData.get(0).get(3).toString();
        }
        return null;
    }
}

