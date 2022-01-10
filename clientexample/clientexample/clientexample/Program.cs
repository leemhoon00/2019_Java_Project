using System;
using System.Collections.Generic;
using System.IO;
using System.IO.Ports;
using System.Linq;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;

namespace clientexample
{
    class Program
    {
        static void Main(string[] args)
        {
            string args0 = "localhost";
            string args1 = "7000";
            SerialPort p = new SerialPort("COM3");

            TcpClient client = new TcpClient(args0, Int32.Parse(args1));
            NetworkStream ns = client.GetStream();
            StreamWriter writer = new StreamWriter(ns);
            p.Open();
            while (true)
            {
                string a = p.ReadLine();
                a = a.Trim();
                writer.WriteLine(a);
                writer.Flush();
                
            }
        }
    }
}
