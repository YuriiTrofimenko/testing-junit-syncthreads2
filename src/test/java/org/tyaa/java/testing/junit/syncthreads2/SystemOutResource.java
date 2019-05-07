/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.testing.junit.syncthreads2;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.rules.ExternalResource;

/**
 *
 * @author yurii
 */
public class SystemOutResource extends ExternalResource {
    
    private PrintStream sysOut;
    private final ByteArrayOutputStream outContent =
            new ByteArrayOutputStream();
 
    @Override
    protected void before() throws Throwable {
        sysOut = System.out;
        System.setOut(new PrintStream(outContent));
    }
 
    @Override
    protected void after() {
        System.setOut(sysOut);
    }
 
    public String asString() {
        return outContent.toString();
    }
}
