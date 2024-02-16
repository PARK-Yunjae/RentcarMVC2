$('.myslider').slick({
	dots: false,
	infinite: false,
	speed: 300,
	slidesToShow: 3,
	slidesToScroll: 3,
	autoplay: true,
  	autoplaySpeed: 2000,
	responsive: [
		{
			breakpoint: 600,
			settings: {
				slidesToShow: 2,
				slidesToScroll: 2
			}
		},
		{
			breakpoint: 480,
			settings: {
				slidesToShow: 1,
				slidesToScroll: 1
			}
		}
		// You can unslick at a given breakpoint now by adding:
		// settings: "unslick"
		// instead of a settings object
	]
});