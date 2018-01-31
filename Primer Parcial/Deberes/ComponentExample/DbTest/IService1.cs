using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace DbTest
{
    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de interfaz "IService1" en el código y en el archivo de configuración a la vez.
    [ServiceContract]
    public interface IService1
    {
        [OperationContract]
        bool SetData(Student value);

        [OperationContract]
        List<Student> GetData();
        /*[OperationContract]
        CompositeType GetDataUsingDataContract(CompositeType composite);*/

        // TODO: agregue aquí sus operaciones de servicio
    }

    // Utilice un contrato de datos, como se ilustra en el ejemplo siguiente, para agregar tipos compuestos a las operaciones de servicio.
    // Puede agregar archivos XSD al proyecto. Después de compilar el proyecto, puede usar directamente los tipos de datos definidos aquí, con el espacio de nombres "DbTest.ContractType".
    [DataContract]
    public class Student
    {
        string student_Name;
        string student_LastName;
        Nullable<System.DateTime> student_Birth_Date;
        [DataMember]
        public string Student_Name
        {
            get { return student_Name; }
            set { student_Name = value; }
        }

        [DataMember]
        public string Student_LastName
        {
            get { return student_LastName; }
            set { student_LastName = value; }
        }
        [DataMember]
        public Nullable<System.DateTime> Student_Birth_Date
        {
            get { return student_Birth_Date; }
            set { student_Birth_Date = value; }
        }
    }
}
