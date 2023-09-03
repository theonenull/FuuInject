package com.example.inject.repository

import com.example.inject.repository.course.CourseInterFace
import com.example.inject.repository.exam.ExamInterFace
import com.example.inject.repository.massage.MassageInterFace
import com.example.inject.repository.yearOptions.YearOptionsInterFace

interface Repository : CourseInterFace,YearOptionsInterFace,ExamInterFace,MassageInterFace{

}