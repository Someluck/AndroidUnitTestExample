package com.example.ivanz.androidunittestexample;

import com.example.ivanz.androidunittestexample.utils.IStudent;
import com.example.ivanz.androidunittestexample.utils.Student;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class StudentTest {

    private IStudent iStudent;


    @BeforeClass
    public static void setUp(){
        System.err.println("BEFORE CLASS");
    }

    @AfterClass
    public static void destroy() {
        System.err.println("AFTER CLASS");
    }

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        iStudent = Mockito.spy(new Student("SomeName", 4, 6.5));
        System.err.println("init");
    }

    @After
    public void close(){
        System.err.println("close");
    }

    @Test
    public void testIsTopStudent(){
        Mockito.when(iStudent.isTopStudent()).thenReturn(true);
        Assert.assertNotEquals(iStudent.isTopStudent(),false);

        Mockito.when(iStudent.isTopStudent()).thenReturn(false);
        Assert.assertEquals(iStudent.isTopStudent(),false);

    }

    @Test
    public void testIsGoesOnAllPairs(){
        Mockito.when(iStudent.isGoesOnAllPairs()).thenReturn(true);
        Assert.assertNotEquals(iStudent.isGoesOnAllPairs(),false);

        Mockito.when(iStudent.isGoesOnAllPairs()).thenReturn(false);
        Assert.assertEquals(iStudent.isGoesOnAllPairs(),false);
    }
}
