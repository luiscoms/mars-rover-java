package br.com.luiscoms.domain;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Coordinates {
    @NonNull
    public Integer x;
    @NonNull
    public Integer y;
}
