# How to set up project

## Tomcat configuration  
Copy the tomcat configuratio from the TomcatConf to your tomcat directory.

## Setup SSL on Tomcat

Generates a certificate in your home directory
* keytool -genkey -alias tomcat -keyalg RSA
 Output: 
PS C:\Users\Filip\workspace\InitialWebApp> keytool -genkey -alias tomcat -keyalg RSA -keystore "YourLocation\Mycert.cert"
Enter keystore password:
Re-enter new password:
What is your first and last name?
  [Unknown]:  filippetrov
What is the name of your organizational unit?
  [Unknown]:
What is the name of your organization?
  [Unknown]:
What is the name of your City or Locality?
  [Unknown]:
What is the name of your State or Province?
  [Unknown]:
What is the two-letter country code for this unit?
  [Unknown]:
Is CN=filippetrov, OU=Unknown, O=Unknown, L=Unknown, ST=Unknown, C=Unknown correct?
  [no]:  yes

Enter key password for <tomcat>
        (RETURN if same as keystore password):
Re-enter new password:
PS C:\Users\Filip\workspace\InitialWebApp>
