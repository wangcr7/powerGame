package com.lambda.why2;

import com.lambda.why.Student;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-07-13 16:31
 */
public class AgeFilter implements StudentFilter{

    @Override
    public boolean compare(Student student) {
        return student.getAge() > 14 ;
    }
}
