
package ru.geekbrains.gkportal.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.apache.log4j.Logger;

/**
 *
 * @author 13th
 */
@WebServlet(name = "sendmail", urlPatterns = {"/sendmail"})
public class SendMail extends HttpServlet {
//static final String ENCODE =  "Windows-1251";
//@Resource(name = "mail/gmail")
//private static Session sessionGMail;

//@Resource(name = "mail/bns")
//private static Session sessionBNS;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean sended = false;
    try {
        // если запуск на прямую, то в опу!, тьфу, на главную !
         request.setCharacterEncoding("utf-8");
        if (request.getAttribute("StartIndex") == null) {
            response.sendRedirect("index");
            return;
        }
        response.setContentType("text/html; charset=utf-8");
       // request.setCharacterEncoding("utf-8");
        String mail = request.getParameter("mail");
        
        if (mail == null) {
            request.getRequestDispatcher(request.getAttribute("pathJsp") + "sendmailPage.jsp").include(request, response);
            return;
        } 
        
        String subject = request.getParameter("subject");
        String text = request.getParameter("text");
//(request.getParameter("text").getBytes("ISO-8859-1"),"Cp1251");
        String mailtype = request.getParameter("mailtype");
        System.out.println("tt"+mailtype);
        //runTest();
        InitialContext ctx = new InitialContext();
        Session session; 
//        BNS_Util.authenticateSysUserLDAP();
        if (mailtype.equals("gmail")) session= (Session) ctx.lookup("mail/gmail"); else 
        { 
           session= (Session) ctx.lookup("mail/bns");
//           session=  Session.getInstance(session.getProperties(), BNS_Util.getPasswordAuthentication());
        }        
        
                        
        sended=sendMail(mail,subject,text,session);
    } catch (Exception ex) {
//        Logger.getLogger(SendMail.class).error("Письмо не отправлено", ex);
        sended = false;
    }
      if (sended) response.getWriter().println("<br><br>Письмо успешно отправлено<br><br><a href=\"index?sendmail\">Вернуться</a><br><br>"); 
        else
      {
          response.getWriter().println("<br><br>Письмо не отправлено<br><br><a href=\"index?sendmail\">Вернуться</a><br><br>");
//          Logger.getLogger(SendMail.class).error("Письмо не отправлено");
          
      }

    }

      public boolean sendMail(String mail,String subject,String text,Session session) throws UnsupportedEncodingException {
          boolean res=true;
        try {
            Message msg = new MimeMessage(session);
        msg.setSubject(subject);
        msg.setRecipient(RecipientType.TO,
                         new InternetAddress(
                         mail,""));
        //msg.setRecipient(RecipientType.CC,
//                         new InternetAddress(
//                         "vladimir_konkov@bns-group.ru",
//                         "ExamName2"));
//        msg.setFrom(new InternetAddress(
//                    "admin@devcolibri.com",
//                    "Admin"));
 
        // Сообщение
        BodyPart messageBodyPart = new MimeBodyPart();
        String s = "тест";
            System.out.println(text);
        messageBodyPart.setText(text);
 
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
 
    /*                // Вложение файла 1
        messageBodyPart = new MimeBodyPart();
        messageBodyPart.setFileName("README1.txt");
        messageBodyPart.setContent(new String(
                                   "file 1 content"),
                                   "text/plain");
        multipart.addBodyPart(messageBodyPart);
 
        // Вложение файла 2
        messageBodyPart = new MimeBodyPart();
        messageBodyPart.setFileName("README2.txt");
        DataSource src = new FileDataSource("c://11//file.txt");
        messageBodyPart.setDataHandler(new DataHandler(src));
        multipart.addBodyPart(messageBodyPart);
 
        // Вложение файла 3
        messageBodyPart = new MimeBodyPart();
        messageBodyPart.setFileName("README3.txt");
        src = new ByteArrayDataSource(
            "file 3 content".getBytes(),
            "text/plain");
        messageBodyPart.setDataHandler(new DataHandler(src));
        multipart.addBodyPart(messageBodyPart);
 */
        msg.setContent(multipart);
 
        // Отправка письма.
        Transport.send(msg);
   
         //message.setText(text);
            
            //message. setFrom(new InternetAddress("sender.bns.group@gmail.com"));
          // message.setHeader("charset", ENCODE);
            
            //message.setReplyTo("sql_automation@bns-group.ru");
            //message.setRecipients(Message.RecipientType.TO,
            //        InternetAddress.parse(mail));
          //  message.setHeader("Content-Type","text/plain;charset="+ENCODE);
          //  message.setHeader("Content-Transfer-Encoding","base64");//"base64"
          //  message.setHeader("MIME-Version","1.0");
            
   
            //System.out.println("Done");

        } catch (Exception e) {
//            Logger.getLogger(SendMail.class).error("Ошибка отправки письма ",e);
            res=false;
        }
        return res;
    }

   /*     public boolean sendBNSMail(String mail,String subject,String text) {
        String hostname = "192.168.2.15";
        boolean res = true;
        int port = 25;

    //   Mailer mailer = new Mailer
        // sender.bns.group@gmail.com
        Properties props = new Properties();
        props.put("mail.smtp.host", hostname);
        props.put("mail.debug", "true");
        props.put("mail.mime.charset",ENCODE);

        Session session = Session.getInstance(props);
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("sql_automation@bns-group.ru"));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(mail));
            msg.setHeader("Content-Type","text/plain;charset="+ENCODE);
            msg.setHeader("Content-Transfer-Encoding","base64");//"base64"
        //    msg.setHeader("MIME-Version","1.0");
            msg.setSubject(new String(subject.getBytes("cp1251"),"cp1251"));
            msg.setText(MimeUtility.encodeText(text,ENCODE,"B"),ENCODE);
            
            
            Transport.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
            res=false;
        }
        return res;
    }
        
        
          public void runTest() throws Exception {
        InitialContext ctx = new InitialContext();
        Session session = (Session) ctx.lookup("mail/bns");
        // Или можно использовать инъекцию.
        //@Resource(name = "mail/mailresource")
        //private Session session;
 
        // Создание email и заголовков.
        Message msg = new MimeMessage(session);
        msg.setSubject("Тема письма");
        msg.setRecipient(RecipientType.TO,
                         new InternetAddress(
                         "admin@chertenok.ru",
                         "ExamName1"));
        msg.setRecipient(RecipientType.CC,
                         new InternetAddress(
                         "vladimir_konkov@bns-group.ru",
                         "ExamName2"));
        msg.setFrom(new InternetAddress(
                    "admin@devcolibri.com",
                    "Admin"));
 
        // Сообщение
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("В этом письме <b>есть<b> файлы.");
 
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
 
        // Вложение файла 1
        messageBodyPart = new MimeBodyPart();
        messageBodyPart.setFileName("README1.txt");
        messageBodyPart.setContent(new String(
                                   "file 1 content"),
                                   "text/plain");
        multipart.addBodyPart(messageBodyPart);
 
        // Вложение файла 2
        messageBodyPart = new MimeBodyPart();
        messageBodyPart.setFileName("README2.txt");
        DataSource src = new FileDataSource("c://11//file.txt");
        messageBodyPart.setDataHandler(new DataHandler(src));
        multipart.addBodyPart(messageBodyPart);
 
        // Вложение файла 3
        messageBodyPart = new MimeBodyPart();
        messageBodyPart.setFileName("README3.txt");
        src = new ByteArrayDataSource(
            "file 3 content".getBytes(),
            "text/plain");
        messageBodyPart.setDataHandler(new DataHandler(src));
        multipart.addBodyPart(messageBodyPart);
 
        msg.setContent(multipart);
 
        // Отправка письма.
        Transport.send(msg);
    }
        
*/        
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                 request.setCharacterEncoding("utf-8");
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
