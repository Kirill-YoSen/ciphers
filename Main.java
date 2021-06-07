package com.company;

public class Main {

    public static void main(String[] args) {
        Chipers chipers = new Chipers();

        chipers.SetDecoded("Test String");
        chipers.IncoderCaesarCipher(3);
        chipers.PrintResult();

        chipers.SetDecoded(chipers.getIncoded());
        chipers.DecoderCaesarCipher(3);
        chipers.PrintResult();

        chipers.SetDecoded("some text");
        chipers.IncoderPolybiusChiper();
        chipers.PrintResult();

        chipers.SetDecoded(chipers.getIncoded());
        chipers.DecoderPolybiusChiper();
        chipers.PrintResult();
    }
}
