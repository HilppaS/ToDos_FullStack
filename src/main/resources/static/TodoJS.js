
   function haeTodot() {
    document.getElementById("ToDo").innerHTML="";
    axios.get('/api/todo')   // Get metodi pyytää tiedot
   .then(function (response) {   // toiminta sen jälkeen, kun tiedot haettu
       console.log(response.data);
       for( var i=0;i< response.data.length; i++){
           console.dir(response.data[i])
           document.getElementById("ToDo").innerHTML +=
               "<tr><td>"+response.data[i].id + ".  " + response.data[i].tehtava+ "</td></tr>";}
        })
        .catch(function (error) {
            // handle error
            console.log(error);
        })
        .finally(function () {
            // always executed
        });
   }

   function lisaaTodo() {
       var lisattava = document.getElementById("lisättävä").value
       axios.post('/api/todo', {
           tehtava: lisattava})
           .then(function (response) {
               console.log(response);
           //    for( var i=0;i< response.data.length; i++){
           //        console.dir(response.data[i])
            //       document.getElementById("ToDo").innerHTML +=
            //           "<tr><td>"+response.data[i].tehtava+"</td></tr>";}
          })
           .catch(function (error) {
               console.log(error);
           })


   }

   function poistaTodo(){
       var id= document.getElementById("poistettava").value
       axios.delete('/api/todo/'+id, {
           id: id})
           .then(function (response) {
               console.log(response);
               document.getElementById("poistettava").innerHTML="";
           })
           .catch(function (error) {
               console.log(error);
           });
   }

   function tyhjennaTaulu(){
       document.getElementById("ToDo").innerHTML="";
       axios.delete('/api/todo/')
           .then(function (response) {
               console.log(response);
           })
           .catch(function (error) {
               console.log(error);
           });
   }

