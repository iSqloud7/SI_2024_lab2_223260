Втора лабораториска вежба по Софтверско инженерство
# Иван Пупиноски, бр на индекс 223260

# Слика од Control Flow Graph
![ControlFlowGraph drawio](https://github.com/iSqloud7/SI_2024_lab2_223260/assets/139021789/38a9d0c3-6edc-4328-88da-d275e61294e4)
# Цикломатска комплексност
I-начин
<br>
M=E-N+2P
Е=48
Н=40
М=48-40+2
М=10
<br>
II-начин
<br>
Цикломатска комплексност за овој код е 10, и истата ја добив со броење на бројот на региони во Control Flow Graph. 

# Every Branch критериум (Test-Cases)
**Тест-1:** allItems = [] <br>
-Бидејќи allItems е null, ќе се фрли исклучок.<br>

**Тест-2:** name = null, barcode = null<br>
-Со креирање на Item, со name = null, на името ќе се додели вредност "unknown", а за barcode, тогаш ќе се фрли исклучок. <br>

**Тест-3:** name = "Item", barcode = "123abc"<br>
-Со креирање на Item, со name = "Item", и barcode = "123abc", за barcode ќе фрли исклучок бидејќи има недозволени знаци во самиот баркод.<br>

**Тест-4:** name = "Item", barcode = "012345", discount = 0.5F, price = 400, payment = 200<br>
-Со креирање на Item со name = "Item", barcode = "012345", discount = 0.5F, и price = 400, за сумата ќе се пресмета 400*0.5 = 200, па потоа од сумата ќе се одземе 30 и ќе добиеме 170 < 200, за кое ќе се врати true. <br>

**Тест-5:** name = "Item", barcode = "012345", discount = 0, price = 100, payment = 50<br>
-Со креирање на Item со name = "Item", barcode = "012345", discount = 0, и price = 100, за сумата ќе се доделе вредноста 100, бидејќи сумата не е помала од наплатата ќе се врати false.<br>

# Multiple Condition критериум (Test-Cases)
-за условот: if(item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0')<br>

**True|True|True:** [item.getPrice() = 400; item.getDiscount() = 0.5F; item.getBarcode() = "012345"]<br>
400 > 300 ќе врати точно, 0.5 > 0 ќе врати точно, '0' == '0' ќе врати точно<br>

**True|True|False:** [item.getPrice() = 400; item.getDiscount() = 0.5F; item.getBarcode() = "123abc"<br>
400 > 300 ќе врати точно, 0.5 > 0 ќе врати точно, '1' == '0' ќе врати неточно<br>

**True|False|X:** item.getPrice() = 400; item.getDiscount() = 0; item.getBarcode() = "xxxxx"<br>
400 > 300 ќе врати точно, 0 > 0 ќе врати неточно, бидејќи во if условот имаме "&&" или логичко "И", доколку еден од условите не е исполнет, останатите не се разгледуваат и нема да се проверат.<br>

**False|X|X:** item.getPrice() = 250; item.getDiscount() = xxxxx; item.getBarcode() = "xxxxx"<br>
250 > 300 ќе врати неточно, бидејќи во if условот имаме "&&" или логичко "И", доколку еден од условите не е исполнет, останатите не се разгледуваат и нема да се проверат.<br>
