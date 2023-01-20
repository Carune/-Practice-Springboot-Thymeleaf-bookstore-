Springboot 와 Thymeleaf, Mysql을 사용한 연습용 북 스토어입니다.

![image](https://user-images.githubusercontent.com/99489461/213600994-0915983e-f002-4776-b0c4-423d5a6ec173.png)



---------------------------------------------------------------------------------------------------------


구조는 간단하게 구매가능한 책(Book~) / 나의 책(MyBook~) 으로 나누어 model, controller, service, repository 구성하였습니다.
![image](https://user-images.githubusercontent.com/99489461/213601239-e45894eb-d2b2-4e72-8368-1f3ae7cd421a.png)


---------------------------------------------------------------------------------------------------------

Available Books 상단바 메뉴 클릭시 구매 가능한 책 리스트가 나옵니다.
간단한 페이징과 검색을 구현하였습니다.

![image](https://user-images.githubusercontent.com/99489461/213601332-c3edce24-c067-4270-ab09-c6a33a7f78ba.png)


이전, 다음 or 페이지 숫자 클릭시 페이지 이동이 가능합니다.

![image](https://user-images.githubusercontent.com/99489461/213601536-0384b3b1-c3d7-46e0-b552-7a43adb520ea.png)

검색시 searchKeyword가 넘어와 해당 단어가 포함된 결과들을 출력합니다.

![image](https://user-images.githubusercontent.com/99489461/213601703-618d5afc-78d4-4f80-9d9e-cdb407b5ff64.png)


컨트롤러에서 페이징과 검색에 대한 작업을 해주고 model 에 해당 변수명으로 addAttribute 해주었습니다.

![image](https://user-images.githubusercontent.com/99489461/213601931-bc24ade3-3d3a-45c2-ad7f-0c9d9e3c737a.png)

서비스에서 getAllBook 메소드에 pageable 파라미터를 받아오면 repository에서 검색 후 반환합니다.
bookSearchList 는 searchKeyword와 pageable 을 받아와서 해당 키워드가 포함된 Name 을 검색 후 반환합니다.

![image](https://user-images.githubusercontent.com/99489461/213602314-723824a7-c088-4634-9e7b-1b7e215ab982.png)
![image](https://user-images.githubusercontent.com/99489461/213602347-b759e1b6-552e-4c3c-a87f-65cec2aac9b6.png)

---------------------------------------------------------------------------------------------------------

타임리프를 사용하여 model 에 addAttribute 한 변수명을 받아와 페이징과 검색, 북리스트들을 뷰에 구현하였습니다.

![image](https://user-images.githubusercontent.com/99489461/213602522-f37d52ab-68c3-4227-a304-44f51095c9f1.png)

---------------------------------------------------------------------------------------------------------

상단 메뉴의 New Book Register을 클릭하면 새로운 책을 등록할 수 있습니다.

![image](https://user-images.githubusercontent.com/99489461/213602704-627d7785-49cd-427d-8bd2-65c898e1943e.png)

![image](https://user-images.githubusercontent.com/99489461/213602735-11dc2fd1-9ec3-4352-bfff-7c285ee4ea46.png)

---------------------------------------------------------------------------------------------------------

또한 Action에서 Add to Mybook을 클릭시 자동으로 My Books로 이동되며 해당 책이 추가됩니다.

![image](https://user-images.githubusercontent.com/99489461/213602868-08c6110a-7988-4e75-9f7f-1313ed63f7db.png)

---------------------------------------------------------------------------------------------------------

연필 버튼 클릭시 책 내용을 edit 가능합니다.
![image](https://user-images.githubusercontent.com/99489461/213603110-ba8364d1-1b53-4650-9693-d60df3873c3e.png)
![image](https://user-images.githubusercontent.com/99489461/213603133-756c86c7-bc38-48b0-9d7e-65414f8edfa0.png)

---------------------------------------------------------------------------------------------------------

휴지통 버튼을 클릭하면 해당 책 내용이 삭제됩니다. (My Books에서도 리스트에서 삭제됩니다)
![image](https://user-images.githubusercontent.com/99489461/213603224-dd30bfea-5cef-41be-bad9-51141ac48711.png)

---------------------------------------------------------------------------------------------------------

DB에서도 조회 가능합니다.
![image](https://user-images.githubusercontent.com/99489461/213603878-6b8259ee-7418-4bab-b0e2-a84d1adda990.png)

![image](https://user-images.githubusercontent.com/99489461/213603925-27a12aaf-1a6c-4c9c-b6b0-918f0eb5326c.png)

![image](https://user-images.githubusercontent.com/99489461/213603961-240b8559-8712-4c87-85e2-87b1bd5c321b.png)

