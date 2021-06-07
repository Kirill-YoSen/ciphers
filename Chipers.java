package com.company;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Chipers {
    private String decoded = "";
    private String incoded = "";

    public void SetDecoded(String str) {
        this.decoded = str;
    }

    public String getDecoded() {
        return decoded;
    }

    public String getIncoded() {
        return incoded;
    }

    public void PrintResult() {
        System.out.println(decoded + " -> " + incoded);
    }

    public void IncoderCaesarCipher(int shift) {
        byte[] bytes = decoded.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            byte buf = bytes[i];

            //BIG LETTER
            if (buf>=65 && buf<=90) {
                buf += shift;
                if (buf > 90) {
                    buf-=26;
                }
            }

            //SMALL LETTER
            if (buf>=97 && buf<=122) {
                buf += shift;
                if (buf > 122) {
                    buf-=26;
                }
            }

            bytes[i] = buf;
        }
        this.incoded = new String(bytes);
    }

    public void DecoderCaesarCipher(int shift) {
        byte[] bytes = decoded.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            byte buf = bytes[i];

            //BIG LETTER
            if (buf>=65 && buf<=90) {
                buf -= shift;
                if (buf < 65) {
                    buf+=26;
                }
            }

            //SMALL LETTER
            if (buf>=97 && buf<=122) {
                buf -= shift;
                if (buf < 97) {
                    buf+=26;
                }
            }

            bytes[i] = buf;
        }
        this.incoded = new String(bytes);
    }

    public void IncoderPolybiusChiper() {
        byte[][] PolybiusSquare = {
                {'A', 'B', 'C', 'D', 'E' },
                {'F', 'G', 'H', 'I', 'K' },
                {'L', 'M', 'N', 'O', 'P' },
                {'Q', 'R', 'S', 'T', 'U' },
                {'V', 'W', 'X', 'Y', 'Z' }
        };
        byte[] bytes = decoded.getBytes();

        for (int i = 0; i < bytes.length; i++) {
            int x, y;
            byte buf = bytes[i];

            if (buf >= 97 && buf <= 122) {
                buf -= 32;
            }

            for (y = 0; y < PolybiusSquare.length; y++) {
                x = Arrays.binarySearch(PolybiusSquare[y], buf);
                if (x >= 0) {
                    //System.out.println((char)buf);
                    if (y == PolybiusSquare.length- 1) {
                        bytes[i] = PolybiusSquare[0][x];
                    } else {
                        bytes[i] = PolybiusSquare[y + 1][x];
                    }
                }
            }
        }
        this.incoded = new String(bytes);
        this.incoded = incoded.replace(" ", "");
    }


    public void DecoderPolybiusChiper() {
        byte[][] PolybiusSquare = {
                {'A','B','C','D','E'},
                {'F','G','H','I','K'},
                {'L','M','N','O','P'},
                {'Q','R','S','T','U'},
                {'V','W','X','Y','Z'}
        };
        byte[] bytes = decoded.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            int x, y;
            byte buf = bytes[i];

            for (y = 0; y < PolybiusSquare.length; y++) {
                x = Arrays.binarySearch(PolybiusSquare[y], buf);
                if (x >= 0) {
                    if (y == 0) {
                        bytes[i] = PolybiusSquare[PolybiusSquare.length-1][x];
                    } else {
                        bytes[i] = PolybiusSquare[y-1][x];
                    }
                }
            }
        }
        this.incoded = new String(bytes);
    }
}