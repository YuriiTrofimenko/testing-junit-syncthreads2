/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.tyaa.java.testing.junit.syncthreads2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Юрий
 */
public class Worker extends Thread
{
    private int mId;
    private Data mData;
    
    public Worker(int _id, Data _data)
    {
        mId = _id;
        mData = _data;
        this.start();
    }

    @Override
    public void run()
    {
        synchronized(mData)
        {
            for (int i = 0; i < 5; i++)
            {
                try
                {
                    while (mId != mData.getState())
                    {                    
                        mData.wait();
                    }
                    if (mId == 1) {
                        mData.Tic();
                    }
                    else
                    {
                        mData.Tak();
                    }
                    mData.notify();
                }
                catch (InterruptedException ex)
                {
                    Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }    
}
