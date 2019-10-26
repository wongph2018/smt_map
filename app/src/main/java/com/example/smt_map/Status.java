package com.example.smt_map;

public enum Status {
    PartiallyOccupied,
    MostlyOccupied,
    FullyOccupied;

    Status nextStatus(Status status){
        System.out.println("Status: " + status);
        if (status.equals(Status.FullyOccupied)  || status.equals(Status.PartiallyOccupied) ) {
            System.out.println("Status - MostlyOccupied");
            return Status.MostlyOccupied;
        } else {
            System.out.println("Status - Else");
            if (Math.random() > 0.5) {
                return Status.FullyOccupied;
            } else {
                return Status.PartiallyOccupied;
            }
        }
    }
}
