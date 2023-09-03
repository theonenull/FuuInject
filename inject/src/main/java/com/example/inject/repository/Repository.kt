package com.example.inject.repository

import com.example.inject.repository.course.CourseInterface
import com.example.inject.repository.exam.ExamInterface
import com.example.inject.repository.massage.MassageInterface
import com.example.inject.repository.yearOptions.YearOptionsInterface

interface Repository : CourseInterface,YearOptionsInterface,ExamInterface,MassageInterface{

}