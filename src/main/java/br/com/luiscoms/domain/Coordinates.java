package br.com.luiscoms.domain;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class Coordinates {
    @NonNull
    public Integer x;
    @NonNull
    public Integer y;
}
