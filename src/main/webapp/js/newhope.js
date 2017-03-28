$(document).ready(function() {
  height_r1 = $(".row1").height();
  document.getElementById("c-b1").style.height = height_r1 + 20 + "px";
  document.getElementById("c-b2").style.height = height_r1 + 45 + "px";
  change_carousel_picture();
});

leaf_animation_done = 0;
rocket_animation_done = 0;

$(document).scroll(function() {
  var activities_offset_top = $(".activities").offset().top;
  var latest_products_offset_top = $(".latest-products").offset().top;
  var prospect_offset_top = $(".prospect").offset().top;
  var this_scrollTop = $(this).scrollTop();
  if (this_scrollTop >= activities_offset_top) {
    $(".activities2next").css("display", "block");
    $(".latest_products2next").css("display", "none");

    if (this_scrollTop <= latest_products_offset_top) {
      $(".latest_products2next").css("display", "none");
    }

    if (this_scrollTop >= latest_products_offset_top) {
      $(".activities2next").css("display", "none");
      $(".latest_products2next").css("display", "block");
    }
    if (this_scrollTop > prospect_offset_top - 200) {
      $(".latest_products2next").css("display", "none");
    }
  }
  else {
    $(".activities2next").css("display", "none");
    $(".latest_products2next").css("display", "none");
  }
  
  if (leaf_animation_done == 0) {       
    var first_half_rule2window_bottom = $(document).scrollTop() + $(window).height() - $(".activities .half-rule").offset().top;
    if (first_half_rule2window_bottom > 100 && first_half_rule2window_bottom < 200) {
      $('img[src$="leaf.png"]').show();
      $('img[src$="leaf-replacement.jpg"]').hide();
      leaf_animation_done = 1;
    }     
  } 

  if (rocket_animation_done == 0) {       
    var second_half_rule2window_bottom = $(document).scrollTop() + $(window).height() - $(".latest-products .half-rule").offset().top;
    if (second_half_rule2window_bottom > 100 && second_half_rule2window_bottom < 200) {
      $('img[src$="rocket.png"]').show();
      $('img[src$="rocket-replacement.jpg"]').hide();
      rocket_animation_done = 1;
    }     
  } 
});

function test() {
  var first_half_rule2window_bottom = $(document).scrollTop() + $(window).height() - $(".activities .half-rule").offset().top;
  alert(first_half_rule2window_bottom); 
}

window.onresize = function() {
  change_carousel_picture();
}

function change_carousel_picture() {
  var totalWidth = $(window).width();
  if(totalWidth < 760) {
    $("#carousel-picture-1").attr("src", "pictures/carousel_slide/1-small.jpg");
    $("#carousel-picture-2").attr("src", "pictures/carousel_slide/2-small.jpg");
    $("#carousel-picture-3").attr("src", "pictures/carousel_slide/3-small.jpg");
  }
  if(totalWidth < 1370) {
    $("#carousel-picture-1").attr("src", "pictures/carousel_slide/1-middle.jpg");
    $("#carousel-picture-2").attr("src", "pictures/carousel_slide/2-middle.jpg");
    $("#carousel-picture-3").attr("src", "pictures/carousel_slide/3-middle.jpg");
    }
  else if(totalWidth < 1930) {
    $("#carousel-picture-1").attr("src", "pictures/carousel_slide/1-large.jpg");
    $("#carousel-picture-2").attr("src", "pictures/carousel_slide/2-large.jpg");
    $("#carousel-picture-3").attr("src", "pictures/carousel_slide/3-large.jpg");
  }
  else {
    $("#carousel-picture-1").attr("src", "pictures/carousel_slide/1-original.jpg");
    $("#carousel-picture-2").attr("src", "pictures/carousel_slide/2-original.jpg");
    $("#carousel-picture-3").attr("src", "pictures/carousel_slide/3-original.jpg");
  }
}

function jump_to_latest_products() {
  window.location.href="#latest-products";
  $(".activities2next").css("display", "none");
};

function jump_to_prospect() {
  window.location.href="#prospect";
  $(".latest_products2next").css("display", "none");
};
