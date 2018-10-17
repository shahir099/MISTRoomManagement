package com.example.kanak.mistroommanagement;


public class floor_numbers {
    String selected_floor,rs,r1,r2,r3,r4;
    int a=1;
    public floor_numbers(String selected_floor) {

        this.selected_floor = selected_floor;
        rs=selected_floor.substring(0,1);

        r1=rs+"01";
        r2=rs+"02";
        r3=rs+"03";
        r4=rs+"04";
    }

    public String getSelected_floor() {
        return selected_floor;
    }
}


