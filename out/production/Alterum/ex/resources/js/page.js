var url = "https://vk.com/al_wall.php";
var requestData = {
  act: "get_wall", 
  al: "1",
  fixed: "50367", 
  offset: "0",
  owner_id: "-76769609",
  type: "own", 
  wall_start_from: "2"
};

function pageGoForward() {
    var startFrom = 1;
    jfxOperations.pageGoForward(startFrom);
}

function pageGoBack() {
    var startFrom = 1;
    jfxOperations.pageGoBack(startFrom);
}