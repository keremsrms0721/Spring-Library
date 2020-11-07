# Kütüphane Projesi (Library Project) !

Kütüphane projesi özgür yazılıma staj için başvuruda bulunduğum projedir.

## Proje nasıl çalıştırılır 
Öncelikle java jdk indirilmesi gerekiyor.https://www.oracle.com/tr/java/technologies/javase/javase-jdk8-downloads.html Buradan işletim sisteminize uygun jdk'yi indirebilirsiniz.Ben windows 10 kullanıyorum.Jdk kurulduktan sonra mavenin de bilgisayarınıza yüklü olması gerek çünkü projeyi jar dosyasına çevirecez.http://maven.apache.org/download.cgi Binary zip archive 	apache-maven-3.6.3-bin.zip bunu indirin.Daha sonra maven dosyasını zipten çıkarıp masaüstüne alın.

![photo1](https://user-images.githubusercontent.com/59603584/98436332-a6a27480-20eb-11eb-8c66-4c857944c60c.png)

Bilgisayarınızda sistem variables kısmına gidip Environment Variables bölümünde User Variables alanında (üst kısım) new'e tıkladıktan sonra ; 

Variable = JAVA_HOME
Value = Javanın yüklendiği yer (örneğin : C:\Program Files\Java\jdk1.8.0_271) bunu yapıştırın ve OK'a basın.

![photo2](https://user-images.githubusercontent.com/59603584/98436334-a73b0b00-20eb-11eb-9540-4766d1afcb24.png)

Sistem variables alanında ise(alt kısım) Path kısmına gelip edite tıklıyoruz oraya maven ve jdk'yi bırakmalıyız çünkü command promptan java -jar <proje.jar> çalıştırmamız gerekiyor.Maven'i bıraktığınız yerde klasörün içerisinde bin klasörü bulunmaktadır bunu ve Javayı kurduğumuz yerde jdk'in içerisinde de bin bulunmakta bunları da System variables de Path bölümüne bırakmalıyız.New -> (maven içerisindeki bin klasörünün pathi örneğin C:\Program Files\apache-maven-3.6.3\bin) daha sonra bir daha New ->(jdk ' içerisindeki bin klasörünün pathi örneğin C:\Program Files\Java\jdk1.8.0_271\bin) daha sonra OK deyip kapatıyoruz hepsini.

![photo3](https://user-images.githubusercontent.com/59603584/98436336-a73b0b00-20eb-11eb-959d-c96ce4b820c8.png)

Sıra projeyi jara açıp çalıştırmamız gerekiyor ama bundan önce önemli iki şey var . Sql'inizin açık olması gerekiyor çünkü sistem data migrations yapacağı için databaseleri ve tabloları kendisi oluşturacak. Eğer sizin sql'inizin username ve passwordunuz farklı ise bunu projede src\main\resources içersinde application.properties i güncellemelisiniz.Şuan projeyi farklı bir bilgisayarda denediğim için şifresini root yaptım.Varsayılan olarak username : root ve password ise boş olarak geliyor.

![photo4](https://user-images.githubusercontent.com/59603584/98436430-2c262480-20ec-11eb-812b-de538c18d831.png)


![photo5](https://user-images.githubusercontent.com/59603584/98436339-a7d3a180-20eb-11eb-89d4-dd1a424928bd.png)

Sıra çalıştırmaya geldi , command promptü açıp projemizin olduğu klasöre geliyoruz. Daha sonra ise şu kodu command prompta yazıyoruz : 

mvn package


![photo6](https://user-images.githubusercontent.com/59603584/98436337-a7d3a180-20eb-11eb-927d-bcd13b530271.png)


kendisi target klasörünün içerisinde projemiz için bir jar dosyası oluşturacak.Sıra projeyi çalıştırmaya geldi.Target klasörüne gelip .jar dosyasının adına bakın.


java -jar target/<jar dosyanız.jar> 


![photo7](https://user-images.githubusercontent.com/59603584/98436340-a86c3800-20eb-11eb-9406-90b9f594e4f8.png)


çalıştırıyoruz ve çalıştıkdan sonra localhost:8080 ile projeyi açıp kullanıyoruz.
Kullanıcıların username ve şifresi;
admin için , username=admin şifre=password
depocu için : username=depocu şifre=password
user için : username=user şifre=password


![photolast](https://user-images.githubusercontent.com/59603584/98438975-4a495000-20ff-11eb-802f-3608f3e8ebef.png)






EXCEPTİON DURUMU ---

Aşağıdaki hata ile karşılaştığınızda application.properties de kullanıcı adı ve şifrenizi bir daha kontrol edin lütfen.

![photo9](https://user-images.githubusercontent.com/59603584/98436330-a5714780-20eb-11eb-8cd8-ce6583c66f31.png)
