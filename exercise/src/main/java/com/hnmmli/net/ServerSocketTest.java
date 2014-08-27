package com.hnmmli.net;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSocketTest
{

    public static void main(String[] args)
    {
        ServerSocket ss = null;
        try
        {
            ss = new ServerSocket(8189);

            Socket incoming = ss.accept();

            InputStream in = incoming.getInputStream();

            OutputStream out = incoming.getOutputStream();

            Scanner ins = new Scanner(in);

            new PrintWriter(out, true);

            while (ins.hasNext())
            {
                System.out.println(ins.nextLine());
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}