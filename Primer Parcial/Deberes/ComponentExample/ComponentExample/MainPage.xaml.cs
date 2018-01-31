using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using Windows.Foundation;
using Windows.Foundation.Collections;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;
using ComponentExample.ServiceReference1;
using System.Threading.Tasks;
using System.Diagnostics;
using System.Collections.ObjectModel;

// La plantilla de elemento Página en blanco está documentada en https://go.microsoft.com/fwlink/?LinkId=402352&clcid=0xc0a

namespace ComponentExample
{
    /// <summary>
    /// Página vacía que se puede usar de forma independiente o a la que se puede navegar dentro de un objeto Frame.
    /// </summary>
    public sealed partial class MainPage : Page
    {
        public MainPage()
        {
            this.InitializeComponent();
        }

        private async void sendButton_Click(object sender, RoutedEventArgs e)
        {
            Service1Client cl = new Service1Client();
            Student s = new Student
            {
                Student_Name = nameTextBox.Text,
                Student_LastName = lNameTextBox.Text,
                Student_Birth_Date=datePicker.Date.Date              

            };
            bool x = await cl.SetDataAsync(s);
            Debug.WriteLine(x);
            

                
        }

        private async void getDataBtn_Click(object sender, RoutedEventArgs e)
        {
            logListBox.Items.Clear();
            Service1Client cl = new Service1Client();
            ObservableCollection<Student> val= await cl.GetDataAsync();
            foreach (Student item in val)
            {
                logListBox.Items.Add("Nombre: " + item.Student_Name + "\nApellido: " + item.Student_LastName + "\nFecha de Nacimiento: "
                    + item.Student_Birth_Date );
            }
        }
    }
}
