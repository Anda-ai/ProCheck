$(window).on('scroll', onScroll); 
    /*
    There isn't a "Stopped Scrolling" event. 
    If you want to do something after the user has finished scrolling, 
    you can set a timer in the "OnScroll" event. 
    If you get another "OnScroll" event fired then reset the timer. 
    When the timer finally does fire, then you can assume the scrolling has stopped. 
    I would think 500 milliseconds would be a good duration to start with.
    */
    var scrollTimer = -1;
    function onScroll(){ 
      if( $(window).scrollTop() + window.innerHeight == document.body.scrollHeight ) { 
        if (scrollTimer != -1)
          clearTimeout(scrollTimer);
        scrollTimer = window.setTimeout( addMore(), 150);
      }
    }
    function addMore(){
      $.get("/getpros", function(data){
          $("#items").append(data);
      });
    }