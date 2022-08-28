package com.lambda.why2;

import com.lambda.why.Student;

/**
 * @program: CristianoRonaldo
 * @description:
 * @author: wang chi
 * @create: 2020-07-13 16:32
 */
public class ScoreFilter  implements StudentFilter{
    @Override
    public boolean compare(Student student) {
        return student.getScore() > 75 ;
    }
}
