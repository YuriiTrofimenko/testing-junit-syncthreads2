/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.java.testing.junit.syncthreads2;

import static org.hamcrest.core.StringContains.containsString;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author yurii
 */
@RunWith(MockitoJUnitRunner.class)
public class WorkerTest {
    
    @InjectMocks Data d = new Data();
    // @InjectMocks private Worker w1 = new Worker(1, d);
    // @InjectMocks private Worker w2 = new Worker(2, d);
    
    @Rule public SystemOutResource sysOut = new SystemOutResource();
    
    public WorkerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of run method, of class Worker.
     */
    @Test
    public void testRun() throws InterruptedException {
        Worker w1 = new Worker(1, d);
        Worker w2 = new Worker(2, d);
        w1.join();
        w2.join();
        Thread.sleep(1000);
        assertThat(sysOut.asString(), containsString("Tic-Tak\nTic-Tak"));
    }
    
}
