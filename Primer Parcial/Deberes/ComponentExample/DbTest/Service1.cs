using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace DbTest
{
    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de clase "Service1" en el código y en el archivo de configuración a la vez.
    public class Service1 : IService1
    {
        public List<Student> GetData()
        {
            List<Student> studentList = new List<Student>();
            students_dbEntities dbAccess = new students_dbEntities();
            dbAccess.student.ToList().ForEach(x => studentList.Add(new Student
            { Student_Name=x.STUDENT_NAME,Student_LastName=x.STUDENT_LNAME,
            Student_Birth_Date=x.STUDENT_BIRTH_DATE}));
            return studentList;
        }

        public bool SetData(Student value)
        {
            students_dbEntities dbAccess = new students_dbEntities();
            student dataIn = new student
            {
                //ID = 1,
                STUDENT_NAME = value.Student_Name,
                STUDENT_LNAME = value.Student_LastName,
                STUDENT_BIRTH_DATE = value.Student_Birth_Date
            };
            Debug.WriteLine("Transaction Started");
            try
            {
                dbAccess.student.Add(dataIn);
                dbAccess.SaveChanges();
                return true;

            }
            catch (Exception e)
            {
                Debug.WriteLine(e.Message);

            }
            return false;
        }

        
    }
}
