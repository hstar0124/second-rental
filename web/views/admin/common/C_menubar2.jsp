<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
				
			</section>
		</div>
		
	</div>
<script>
	$(document).ready(function() {
		$('.middleCon').each(function() {

			var highestBox = 0;
			$('.EqHeightDiv', this).each(function() {

				if ($(this).height() > highestBox)
					highestBox = $(this).height();
			});

			$('.EqHeightDiv', this).height(highestBox);

		});

		function title() {
			$("#mainTitle").text(arguments[0]);
			$("#cate_1").text(arguments[1]);
			$("#cate_2").text(arguments[2]);
		}
		;
		

	});
		function ready(title, cate1, cate2){
			$("#mainTitle").text(title);
			$("#cate_1").text(cate1);
			$("#cate_2").text(cate2);
		}
</script>
</body>
</html>