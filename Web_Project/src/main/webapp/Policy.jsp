<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="lang.Language" var="bundle" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title><fmt:message key="policy" bundle="${bundle}" /></title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/policy.css">
</head>
</head>
<body class="d-flex flex-column min-vh-100">

	<jsp:include page="/Header.jsp"></jsp:include>

	<!-- Breadcrumb -->
	<div class="container mt-3">
		<nav aria-label="breadcrumb">
			<ol class="breadcrumb p-3 bg-body-tertiary rounded-3">
				<li class="breadcrumb-item"><a class="text-decoration-none"
					href="#"><fmt:message key="home" bundle="${bundle}" /></a></li>
				<li class="breadcrumb-item active" aria-current="page"><fmt:message key="policy" bundle="${bundle}" /></li>
			</ol>
		</nav>
	</div>
	<!-- End of Breadcrumb -->

	<main class="flex-grow-1 my-3">
		<div class="container">
			<h2 class="policy-title text-center text-uppercase fw-bold my-3">
				<fmt:message key="policy.store" bundle="${bundle}" />
			</h2>

			<div class="accordion mx-auto" id="accordionExample">
				<!-- Policy item -->
				<div class="card mb-2 rounded-3 border-black">
					<div class="card-header bg-transparent border-bottom-0"
						id="headingOne">
						<h2 class="mb-0">
							<a
								class="policy-type btn btn-link d-flex align-items-center justify-content-between px-0 collapsed"
								data-bs-toggle="collapse" href="#collapseOne"
								aria-expanded="true" aria-controls="collapseOne"> 
								<fmt:message key="policy.refund" bundle="${bundle}" /> 
								<span class="icon"> 
									<i class="fa fa-chevron-down"></i>
								</span>
							</a>
						</h2>
					</div>
					<div id="collapseOne" class="collapse" aria-labelledby="headingOne"
						data-bs-parent="#accordionExample">
						<hr class="mx-2 my-0">
						<div class="policy-content card-body">
							 <p>Để đảm bảo quyền lợi của quý khách, Phát Lộc chấp nhận yêu
								cầu đổi/ trả sản phẩm hoặc hoàn tiền/ cọc theo các điều khoản và
								dịch vụ như sau:</p>
							<h5>Những trường hợp đổi/ trả hoặc hoàn tiền/ cọc:</h5>
							<ul>
								<li>Sản phẩm bị lỗi từ nhà sản xuất.</li>
								<li>Sản phẩm bị giao sai về số lượng, thông tin và mẫu mã
									so với đơn đặt hàng.</li>
								<li>Đơn hàng thanh toán trả trước bị hủy hoặc chưa giao
									thành công đến quý khách.</li>
							</ul>
							<h5>Điều kiện đổi/ trả hoặc hoàn tiền/ cọc</h5>
							<ul>
								<li>Sản phẩm Phát Lộc nhận phải còn nguyên vẹn, không có
									dấu hiệu đã qua sử dụng.</li>
								<li>Trong trường hợp sản phẩm bị lỗi hoặc hư hại do quá
									trình vận chuyển, quý khách vui lòng cung cấp video mở hàng/
									hình ảnh hàng hóa ngay sau khi nhận hàng để Phát Lộc xác nhận.
								</li>
							</ul>
							<h5>Quy trình đổi/ trả hoặc hoàn tiền/ cọc</h5>
							<ul>
								<li>Bước 1: Khách hàng liên hệ với Phát Lộc yêu cầu hoàn
									tiền. Để quá trình hoàn tiền được thuận lợi quý khách vui lòng
									cung cấp hình ảnh sản phẩm và xác nhận thời gian nhận hàng.</li>
								<li>Bước 2: Phát Lộc rà soát và phản hồi kết quả soát xét.</li>
								<li>Bước 3: Phát Lộc tiến hành thủ tục hoàn tiền.</li>
							</ul>
							<h5>Thời gian đổi/ trả hoặc hoàn tiền/ cọc</h5>
							<ul>
								<li>Thời gian hoàn tiền dự kiến tính từ ngày Phát Lộc xác
									nhận tiến hành thủ tục: Từ 7 đến 15 ngày làm việc.</li>
								<li>Phát Lộc chịu hoàn toàn chi phí vận chuyển đổi/ trả.</li>
							</ul>
							<h5>Quy định đặt cọc</h5>
							<p>Trường hợp đơn hàng giá trị cao trên 20 triệu, quý khách
								vui lòng đặt cọc trước.</p>
						</div>
					</div>
				</div>

				<!-- Policy item -->
				<div class="card mb-2 rounded-3 border-black">
					<div class="card-header bg-transparent border-bottom-0"
						id="headingTwo">
						<h2 class="mb-0">
							<a
								class="policy-type btn btn-link d-flex align-items-center justify-content-between px-0 collapsed"
								data-bs-toggle="collapse" href="#collapseTwo"
								aria-expanded="false" aria-controls="collapseTwo"> 
								<fmt:message key="policy.delivery" bundle="${bundle}" />  
								<span class="icon"> 
									<i class="fa fa-chevron-down"></i>
								</span>
							</a>
						</h2>
					</div>
					<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
						data-bs-parent="#accordionExample">
						<hr class="mx-2 m-0">
						<div class="policy-content card-body">
							<h5>Chi phí và phạm vi giao hàng</h5>
							<p>Với cam kết phục vụ tốt nhất, Phát Lộc và đối tác hân hạnh
								giao hàng đến quý khách hàng trên khắp 63 tỉnh thành và không
								thu phí vận chuyển.</p>
							<h5>Thời gian giao hàng nhanh</h5>
							<p>Thời gian giao dự kiến sẽ được thể hiện cụ thể trong quá
								trình đặt hàng dựa vào khoảng cách đến nhà khách từ cửa hàng gần
								nhất có hàng</p>
							<p>Thời gian dự kiến được tính từ lúc chuyên viên tư vấn Phát
								Lộc liên hệ khách xác nhận đơn hàng thành công và có thể dao
								động sớm hoặc hy hữu muộn hơn.</p>
							<p>Thời gian giao hàng tại khu vực biển đảo có thể dài hơn dự
								kiến từ 3-5 ngày tùy vào tình hình thời tiết và chuyến tàu ra
								đảo.</p>
							<h5>Quy cách giao hàng</h5>
							<p>Phát Lộc cam kết tất cả các đơn hàng được giao đều là hàng
								chính hãng, đi kèm hóa đơn, được đóng gói bằng bao bì có logo,
								dán băng keo và 04 tem niêm phong của Phát Lộc.</p>
							<img class="d-block mx-auto"
								src="https://cdn.pnj.io/images/2023/09/hinh2.png"
								alt="hình minh họa">
							<p class="fst-italic text-center">Trang sức được xếp gọn
								gàng, ngay ngắn trong hộp.</p>
							<img class="d-block mx-auto"
								src="https://cdn.pnj.io/images/2023/09/hinh1.png"
								alt="hình minh họa">
							<p class="fst-italic text-center">Hộp hàng được gói kín, niêm
								phong bằng 04 tem Phát Lộc ở giữa mỗi nắp hộp. Xung quanh thành
								hộp được dán bằng băng keo thương hiệu Phát Lộc.</p>
							<img class="d-block mx-auto"
								src="https://cdn.pnj.io/images/2023/tui_silver_3_goc1.png"
								alt="hình minh họa">
							<p class="fst-italic text-center">Phát LộcSilver sẽ được đóng
								gói trong túi và dán 1 tem niêm phong bên ngoài.</p>
							<h5>Phản hồi về dịch vụ giao hàng</h5>
							<p>Nếu có bất kỳ vấn đề phát sinh trong khâu giao hàng khiến
								quý khách hàng không hài lòng, Phát Lộc xin thành thật cáo lỗi
								và mong quý khách hàng có thể liên hệ phản ánh trực tiếp với
								Phát Lộc để chúng tôi có thể nâng cao chất lượng dịch vụ.</p>
							<p>Tổng đài 1800 54 54 57 hoàn toàn miễn phí từ 08:00 đến
								21:00 (kể cả lễ Tết).</p>
						</div>
					</div>
				</div>

				<!-- Policy item -->
				<div class="card mb-2 rounded-3 border-black">
					<div class="card-header bg-transparent border-bottom-0"
						id="headingThree">
						<h2 class="mb-0">
							<a
								class="policy-type btn btn-link d-flex align-items-center justify-content-between px-0 collapsed"
								data-bs-toggle="collapse" href="#collapseThree"
								aria-expanded="false" aria-controls="collapseThree"> 
								<fmt:message key="policy.warranty" bundle="${bundle}" /> 
								<span class="icon"> 
									<i class="fa fa-chevron-down"></i>
								</span>
							</a>
						</h2>
					</div>
					<div id="collapseThree" class="collapse"
						aria-labelledby="headingThree" data-bs-parent="#accordionExample">
						<hr class="mx-2 m-0">
						<div class="policy-content card-body">
							<ul>
								<li>Miễn phí bảo hành 3 tháng đầu về mặt kỹ thuật, nước xi.
									Từ tháng thứ 4 đến hết tháng thứ 12 áp dụng mức phí theo quy
									định.</li>
								<li>Miễn phí thay đá tổng hợp trong vòng 12 tháng. (Lưu ý
									đá dán trên charm không hỗ trợ bảo hành).</li>
								<li>Trên 12 tháng không nhận bảo hành (chỉ nhận siêu âm làm
									sạch miễn phí bằng máy siêu âm chuyên dụng).</li>
								<li>Trường hợp mất hóa đơn (nếu có) và có thể truy xuất
									thời gian xuất bán sẽ nhận làm bảo hành nếu sản phẩm còn trong
									thời hạn bảo hành.</li>
								<li>Đối với sản phẩm bạc nhập Ý Mazzaretto – Italy: không
									nhận bảo hành (do tính chất đặc trưng của sản phẩm), sản phẩm
									được siêu âm miễn phí vô thời hạn.</li>
								<li>Đối với dòng sản phẩm charm DIY chỉ nhận bảo hành sản
									phẩm trong các trường hợp sau:
									<ul>
										<li>Sản phẩm là mẫu bạc hoàn toàn (không gắn đá, nhựa,
											thủy tinh).</li>
										<li>Mẫu bạc có phủ colorit.</li>
									</ul>
								</li>
								<li>Đối với sản phẩm Bạc gắn kim cương:
									<ul>
										<li>Viên kim cương sẽ được bảo hành miễn phí trong 6
											tháng đầu lỗi kỹ thuật.</li>
										<li>Các trường hợp không phải lỗi kỹ thuật hoặc từ tháng
											thứ 7 đến tháng thứ 12 sẽ tính phí kim cương theo giá bán
											Phát Lộc được ban hành trên hệ thống.</li>
										<li>Sau 12 tháng sẽ không nhận bảo hành sản phẩm (kể cả
											bảo hành kim cương), chỉ nhận làm sạch miễn phí bằng máy siêu
											âm chuyên dụng.</li>
									</ul>
								</li>
							</ul>
						</div>
					</div>
				</div>

				<!-- Policy item -->
				<div class="card mb-2 rounded-3 border-black">
					<div class="card-header bg-transparent border-bottom-0"
						id="headingFour">
						<h2 class="mb-0">
							<a
								class="policy-type btn btn-link d-flex align-items-center justify-content-between px-0 collapsed"
								data-bs-toggle="collapse" href="#collapseFour"
								aria-expanded="false" aria-controls="collapseFour">
								<fmt:message key="policy.privacy" bundle="${bundle}" /> 
								<span class="icon"> 
									<i class="fa fa-chevron-down"></i>
								</span>
							</a>
						</h2>
					</div>
					<div id="collapseFour" class="collapse"
						aria-labelledby="headingFour" data-bs-parent="#accordionExample">
						<hr class="mx-2 m-0">
						<div class="policy-content card-body">
							<h5>Mục đích thu thập thông tin cá nhân của khách hàng</h5>
							<p>Cung cấp dịch vụ và quản lý, sử dụng thông tin cá nhân của
								khách hàng nhằm mục đích quản lý cơ sở dữ liệu của khách hàng và
								kịp thời xử lý các tình huống phát sinh (nếu có).</p>
							<p>Mục đích của việc thu thập thông tin là nhằm xây dựng
								thống thống mang lại nhiều tiện ích nhất cho khách Hàng. Vì thế,
								việc sử dụng thông tin sẽ phục vụ cho những hoạt động sau:</p>
							<ul>
								<li>Cung cấp dịch vụ và gửi thông báo về các hoạt động trao
									đổi thông tin giữa khách hàng và Phát Lộc.</li>
								<li>Ngăn ngừa các hoạt động phá hủy, chiếm đoạt tài khoản
									hoặc các hoạt động giả mạo.</li>
								<li>Liên lạc giải quyết khiếu nại với khách hàng.</li>
								<li>Xác nhận và trao đổi thông tin về giao dịch của khách
									hàng tại Phát Lộc.</li>
								<li>Trong trường hợp có yêu cầu của cơ quan quản lý nhà
									nước có thẩm quyền.</li>
							</ul>
							<h5>Cam kết bảo mật thông tin cá nhân của người tiêu dùng</h5>
							<p>Thông tin cá nhân của khách hàng trên website được ban
								quản trị cam kết bảo mật tuyệt đối theo chính sách bảo mật thông
								tin đã được đăng tải. Việc thu thập và sử dụng thông tin của
								khách hàng chỉ được thực hiện khi có sự đồng ý của chính khách
								hàng trừ những trường hợp pháp luật có quy định khác và quy định
								này.</p>
							<p>Không sử dụng, không chuyển giao, cung cấp hoặc tiết lộ
								cho bên thứ 3 về thông tin cá nhân của khách hàng khi không có
								sự đồng ý ngoại trừ các trường hợp được quy định tại quy định
								này hoặc quy định của pháp luật.</p>
							<p>Trong trường hợp máy chủ lưu trữ thông tin bị hacker tấn
								công dẫn đến mất dữ liệu cá nhân của khách hàng, ban quản trị có
								trách nhiệm thông báo và làm việc với cơ quan chức năng điều tra
								và xử lý kịp thời, đồng thời thông báo cho khách hàng được biết
								về vụ việc.</p>
							<p>Bảo mật tuyệt đối mọi thông tin giao dịch trực tuyến của
								khách hàng bao gồm thông tin hóa đơn kế toán chứng từ số hóa tại
								khu vực dữ liệu trung tâm an toàn cấp 1 của Phát Lộc.</p>
							<h5>Phương tiện và công cụ để người tiêu dùng tiếp cận và
								chỉnh sửa dữ liệu thông tin cá nhân của mình</h5>
							<p>Khách hàng có quyền tự kiểm tra, cập nhật hoặc hủy bỏ
								thông tin cá nhân của mình bằng cách đăng nhập vào website và
								chỉnh sửa hoặc yêu cầu ban quản trị thực hiện việc này.</p>
							<p>Khách hàng có quyền gửi khiếu nại về việc lộ thông tin cá
								nhân của mình cho bên thứ 3 đến ban quản trị. Khi tiếp nhận
								những phản hồi này, Phát Lộc sẽ xác nhận lại thông tin, chịu
								trách nhiệm trả lời lý do cũng như hướng dẫn khách hàng khôi
								phục và bảo mật lại thông tin.</p>
							<h5>Cơ chế tiếp nhận và giải quyết khiếu nại liên quan đến
								việc thông tin khách hàng</h5>
							<p>Khi phát hiện thông tin cá nhân của mình bị sử dụng sai
								mục đích hoặc phạm vi, khách hàng có thể gửi thông tin phản ánh
								và cung cấp chứng cứ liên quan tới vụ việc cho ban quản trị. Ban
								quản trị cam kết sẽ phản hồi ngay lập tức hoặc muộn nhất là
								trong vòng 24h làm việc kể từ thời điểm nhận được khiếu nại.</p>
							<p>Các hình thức tiếp nhận thông tin khiếu nại:</p>
							<ul>
								<li>Qua điện thoại: 1800 01 23 45</li>
								<li>Qua email: plj@gmail.com.vn</li>
							</ul>
						</div>
					</div>
				</div>

				<!-- Policy item -->
				<div class="card mb-2 rounded-3 border-black">
					<div class="card-header bg-transparent border-bottom-0"
						id="headingFive">
						<h2 class="mb-0">
							<a
								class="policy-type btn btn-link d-flex align-items-center justify-content-between px-0 collapsed"
								data-bs-toggle="collapse" href="#collapseFive"
								aria-expanded="false" aria-controls="collapseFive"> 
								<fmt:message key="policy.data_handling" bundle="${bundle}" /> 
								<span class="icon"> 
									<i class="fa fa-chevron-down"></i>
								</span>
							</a>
						</h2>
					</div>
					<div id="collapseFive" class="collapse"
						aria-labelledby="headingFive" data-bs-parent="#accordionExample">
						<hr class="mx-2 m-0">
						<div class="policy-content card-body">
							<p>
								Thông tin dữ liệu cá nhân cùng những điều khoản và điều kiện về
								xử lý dữ liệu cá nhân theo <strong>Nghị định số
									13/2023NĐ-CP</strong> về bảo vệ dữ liệu cá nhân.
							</p>
							<p>Trong quá trình cung cấp dịch vụ, Phát Lộc tôn trọng và
								cam kết sẽ bảo mật những thông tin mang tính riêng tư theo quy
								định của pháp luật Việt Nam. Để đảm bảo tính bảo mật của thông
								tin khách hàng, Phát Lộc thực hiện các nguyên tắc sau:</p>
							<h5>Tổ chức, cá nhân được xử lý Dữ liệu cá nhân của Khách
								hàng</h5>
							<ol>
								<li>Phát Lộc (bao gồm người lao động, nhân sự của Phát Lộc
									được phân công, giao nhiệm vụ xử lý Dữ liệu cá nhân của Khách
									hàng).</li>
								<li>Công ty cung cấp dịch vụ liên quan đến hoạt kinh doanh
									của Phát Lộc, bao gồm nhưng không giới hạn công ty cung cấp
									dịch vụ bưu chính, viễn thông, xử lý dữ liệu, công nghệ thông
									tin, hỗ trợ công nghệ, trung tâm dữ liệu, vận hành Sản phẩm,
									vận hành các trang tin điện tử, ứng dụng, thiết bị của Phát
									Lộc.</li>
								<li>Công ty cung cấp dịch vụ thanh toán và các dịch vụ có
									liên quan đến các giao dịch thanh toán qua trang tin điện tử,
									ứng dụng.</li>
								<li>Công ty cung cấp dịch vụ kế toán, kiểm toán, định giá,
									thẩm định giá, công ty luật và các đơn vị tư vấn khác của Phát
									Lộc.</li>
								<li>Các bên giao dịch/dự định giao dịch mua bán, chuyển
									nhượng, chuyển giao việc kinh doanh và/hoặc tài sản và/hoặc vốn
									góp, cổ phần của Phát Lộc.</li>
								<li>Các cá nhân, tổ chức có ý định thanh toán bất kỳ khoản
									tiền chưa thanh toán nào của Khách hàng với Phát Lộc.</li>
								<li>Các cá nhân, tổ chức, Cơ quan nhà nước có thẩm quyền
									hoặc Bên thứ ba khác mà Phát Lộc được phép hoặc bắt buộc phải
									tiết lộ theo quy định pháp luật và/hoặc theo các thỏa thuận hợp
									pháp của Phát Lộc và Bên thứ ba.</li>
								<li>Tổ chức, cá nhân khác theo quy định của pháp luật và
									phù hợp với mục đích xử lý Dữ liệu cá nhân của Khách hàng.</li>
							</ol>
							<h5>Quyền và nghĩa vụ của Khách hàng</h5>
							<p>Quyền của Khách hàng:</p>
							<ul>
								<li>Quyền được biết: Khách hàng được quyền biết thông tin
									về mục đích, cách thức, phạm vi, loại dữ liệu Phát Lộc xử lý và
									các nội dung khác liên quan đến xử lý Dữ liệu cá nhân của Khách
									hàng.</li>
								<li>Quyền đồng ý: Khách hàng được đồng ý hoặc không đồng ý
									cho phép Phát Lộc xử lý Dữ liệu cá nhân của mình trừ trường hợp
									xử lý dữ liệu cá nhân trong trường hợp không cần sự đồng ý của
									Khách hàng theo quy định tại Thông báo này và quy định pháp
									luật có liên quan.</li>
								<li>Quyền rút lại sự đồng ý: Khách hàng được quyền rút lại
									sự đồng ý của mình, nhưng phải tuân theo các nội dung liên quan
									tại Thông báo này và quy định của pháp luật.</li>
								<li>Quyền phản đối xử lý dữ liệu: Khách hàng được phản đối
									Phát Lộc xử lý Dữ liệu cá nhân của mình nhằm ngăn chặn hoặc hạn
									chế tiết lộ Dữ liệu cá nhân hoặc sử dụng cho mục đích quảng
									cáo, tiếp thị không đúng quy định tại Thông báo này và quy định
									pháp luật có liên quan. Phát Lộc sẽ thực hiện yêu cầu của Khách
									hàng trong 72 giờ sau khi nhận được yêu cầu.</li>
								<li>Quyền truy cập, chỉnh sửa Dữ liệu cá nhân: Khách hàng
									được quyền truy cập, xem, chỉnh sửa Dữ liệu cá nhân của mình
									theo cách thức, phương thức được quy định tại Thông báo này và
									quy định pháp luật có liên quan.</li>
								<li>Quyền xóa dữ liệu: Khách hàng được xóa hoặc yêu cầu
									Phát Lộc xóa Dữ liệu cá nhân của Khách hàng theo quy định tại
									Thông báo này và quy định pháp luật.</li>
								<li>Quyền hạn chế xử lý dữ liệu: Khách hàng được quyền hạn
									chế Phát Lộc xử lý Dữ liệu cá nhân của Khách hàng. Phát Lộc sẽ
									thực hiện theo yêu cầu của Khách hàng trong thời hạn 72 giờ sau
									khi nhận được yêu cầu của Khách hàng.</li>
								<li>Quyền yêu cầu Phát Lộc cung cấp dữ liệu: Khách hàng
									được quyền yêu cầu Phát Lộc cung cấp Dữ liệu cá nhân của mình
									với trình tự, thủ tục yêu cầu như sau:
									<ul>
										<li>Khi có yêu cầu cung cấp dữ liệu cá nhân, Khách hàng
											hoặc đại diện hợp pháp của Khách hàng gửi Phiếu yêu cầu cung
											cấp dữ liệu cá nhân theo mẫu đến Phát Lộc bằng một trong các
											phương thức sau (i) trực tiếp tại trụ sở của Phát Lộc; hoặc
											(ii) qua email của Phát Lộc; (iii) qua dịch vụ bưu chính.</li>
										<li>Phát Lộc sẽ cử nhân sự có trách nhiệm tiếp nhận yêu
											cầu cung cấp dữ liệu cá nhân của Khách hàng và theo dõi quá
											trình, danh sách cung cấp dữ liệu cá nhân theo yêu cầu;
											Trường hợp dữ liệu cá nhân được yêu cầu không thuộc thẩm
											quyền thì Phát Lộc sẽ thông báo và hướng dẫn Khách hàng đến
											cơ quan có thẩm quyền hoặc thông báo rõ ràng việc không thể
											cung cấp dữ liệu cá nhân.</li>
										<li>Trong thời hạn 72 giờ sau khi nhận được yêu cầu cung
											cấp dữ liệu cá nhân hợp lệ của Khách hàng Phát Lộc sẽ thông
											báo về thời hạn, địa điểm, hình thức cung cấp dữ liệu cá
											nhân; chi phí thực tế để in, sao, chụp, gửi thông tin qua
											dịch vụ bưu chính, fax (nếu có) và phương thức, thời hạn
											thanh toán.</li>
									</ul>
								</li>
								<li>Quyền khiếu nại, tố cáo, khởi kiện: Khách hàng có quyền
									khiếu nại, tố cáo hoặc khởi kiện theo quy định của pháp luật.</li>
								<li>Quyền yêu cầu bồi thường thiệt hại: Khách hàng có quyền
									yêu cầu bồi thường thiệt hại theo quy định của pháp luật khi
									xảy ra vi phạm quy định về bảo vệ dữ liệu cá nhân của mình.</li>
								<li>Quyền tự bảo vệ: Khách hàng có quyền tự bảo vệ theo quy
									định của pháp luật hoặc yêu cầu cơ quan, tổ chức có thẩm quyền
									thực hiện các phương thức bảo vệ quyền dân sự như công nhận,
									tôn trọng, bảo vệ và bảo đảm quyền dân sự của mình; buộc chấm
									dứt hành vi xâm phạm; buộc xin lỗi, cải chính công khai; buộc
									thực hiện nghĩa vụ; buộc bồi thường thiệt hại; hủy quyết định
									cá biệt trái pháp luật của cơ quan, tổ chức, người có thẩm
									quyền; và yêu cầu khác theo quy định của luật.</li>
							</ul>
							<p>Nghĩa vụ của Khách hàng:</p>
							<ul>
								<li>Tự bảo vệ Dữ liệu cá nhân của mình; yêu cầu các tổ
									chức, cá nhân khác có liên quan bảo vệ Dữ liệu cá nhân của
									mình.</li>
								<li>Tôn trọng, bảo vệ Dữ liệu cá nhân của người khác.</li>
								<li>Cung cấp đầy đủ, chính xác Dữ liệu cá nhân khi đồng ý
									cho phép Phát Lộc xử lý Dữ liệu cá nhân của Khách hàng.</li>
								<li>Cam kết, đảm bảo và chịu trách nhiệm khi cung cấp Dữ
									liệu cá nhân của Bên thứ ba cho Phát Lộc. Khách hàng cam kết
									rằng đã có được sự ủy quyền hợp pháp của Bên thứ ba đó cho việc
									cung cấp và xử lý dữ liệu cá nhân và đã thông báo cho Bên thứ
									ba biết rõ và đồng ý tất cả nội dung của Thông báo này, kể cả
									việc cho phép Phát Lộc xử lý dữ liệu cá nhân của Bên thứ ba
									phục vụ cho một hoặc một số hoặc tất cả mục đích xử lý được nêu
									tại Thông báo này.</li>
								<li>Thông báo, cập nhật, bổ sung kịp thời, chính xác Dữ
									liệu cá nhân của mình cho Phát Lộc phù hợp với mục đích xử lý
									dữ liệu.</li>
								<li>Tuân thủ các điều kiện (nếu có) khi thực hiện các quyền
									của Khách hàng được quy định tại Thông báo này và quy định pháp
									luật có liên quan.</li>
								<li>Các nghĩa vụ khác theo Thông báo này và quy định pháp
									luật.</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>

	<jsp:include page="/Footer.jsp"></jsp:include>

	<script>
    document.querySelectorAll('.policy-type').forEach(item => {
        item.addEventListener('click', function (e) {
            e.preventDefault(); // Ngăn hành động mặc định của link

            // Lấy thẻ collapse được liên kết với item
            const collapseTargetId = this.getAttribute('href');
            const collapseTarget = document.querySelector(collapseTargetId);

            // Khi thẻ collapse mở hoàn toàn, cuộn trang đến vị trí của nó
            collapseTarget.addEventListener('shown.bs.collapse', function () {
                // Tính toán vị trí cần cuộn
                const parentCard = collapseTarget.closest('.card'); // Thẻ cha chứa tiêu đề và nội dung
                const elementTop = parentCard.getBoundingClientRect().top; // Vị trí từ thẻ đến đầu viewport
                const scrollPosition = window.pageYOffset + elementTop; // Tính toán vị trí cuối cùng cần cuộn

                // Cuộn đến vị trí
                window.scrollTo({
                    top: scrollPosition,
                    behavior: 'smooth'
                });
            }, { once: true }); // Đảm bảo sự kiện chỉ chạy một lần
        });
    });
</script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
		integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
		crossorigin="anonymous"></script>
</body>
</html>