$(document).ready(() => {

    let idOfProductToEdit;


    $('#add-button-modal').click(() => {

        const name = $('#modal-name').val();
        const companyName = $('#modal-companyName').val();
        const price = $('#modal-price').val();
        const stock = $('#modal-stock').val();
        const category = $('#modal-category').val();


        const newProduct = {
            name: name,
            companyName: companyName,
            price: price,
            stock: stock,
            category: category
        };

        if (idOfProductToEdit == null) {

            addProduct(newProduct);
        } else {

            editProduct(idOfProductToEdit, newProduct);
        }
    });


    $('.delete-icon').click(function () {
        const productId = this.parentElement.id;

        fetch('products/' + productId, {
            method: 'DELETE'
        }).then(response => location.reload());
    });


    $('.edit-icon').click(function () {
        //idOfProductToEdit = this.parentElement.id;
        const row = this.parentElement.parentElement;

        const name2 = row.children[1].innerText;
        const companyName2 = row.children[2].innerText;
        const price2 = row.children[3].innerText;
        const stock2 = row.children[4].innerText;
        const category2 = row.children[5].innerText;

        $('#modal-name').val(name2);
        $('#modal-companyName').val(companyName2);
        $('#modal-price').val(price2);
        $('#modal-stock').val(stock2);
        $('#modal-category').val(category2);
    });

    function addProduct(newProduct) {

        fetch('products', {
            method: 'POST',
            body: JSON.stringify(newProduct),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {

            if (response.ok) {

                location.reload();
            } else {

                alert("There are errors " + response.status);
            }
        });
    }

    function editProduct(idOfProductToEdit, newProduct) {

        fetch('products/' + idOfProductToEdit, {
            method: 'PUT',
            body: JSON.stringify(newProduct),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(response => {

              if (response.ok) {

                  location.reload();
              } else {

                  alert("There are errors " + response.status);
              }
          });
    };


    $('#add-product-button').click(function () {


        $('#modal-name').val('');
        $('#modal-companyName').val('');
        $('#modal-price').val('');
        $('#modal-stock').val('');
        $('#modal-category').val('');
    })
})