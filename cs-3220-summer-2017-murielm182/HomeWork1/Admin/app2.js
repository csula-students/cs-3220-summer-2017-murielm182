// single state store
class Store {
    constructor (storage) {
        this.storage = storage; // assuming local storage will be passed in as storage
        // these are the key name you can use in Store
        this.CART_KEY = 'CART';
        this.QUEUE_KEY = 'QUEUE';
        this.FOODS_KEY = 'FOODS';
    }

    // you can get item by store.cartItems
    get cartItems () {
        return JSON.parse(this.storage.getItem(this.CART_KEY));
    }

    // to call setter, simply "assign" like store.cartItems = something
    set cartItems (cartItems) {
        this.storage.setItem(this.CART_KEY, JSON.stringify(cartItems));
    }

    get queue () {
        return JSON.parse(this.storage.getItem(this.QUEUE_KEY));
    }

    set queue (queue) {
        this.storage.setItem(this.QUEUE_KEY, JSON.stringify(queue));
    }

    get foods () {
        return JSON.parse(this.storage.getItem(this.FOODS_KEY));
    }

    set foods (foods) {
        this.storage.setItem(this.FOODS_KEY, JSON.stringify(foods));
    }
}

class Cart {
    // take dom element into JavaScript class to attachment events
    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.items = this.store.cartItems;
        this.init();
    }

    init () {
        // Render a list of items under root element
        this.render();
        // TODO: attach remove cart items to rendered HTML
    }

    destroy () {
        // TODO: remove all the events attached from init
    }

    // remove an item from shopping cart
    removeItem (item) {
        // TODO: logic to remove an item from cart
        // call render method when the item is removed to update view
        var fill = this.items;
        fill = fill.filter(a => a != fill[item]);
        console.log(fill);
        this.store.cartItems = fill;
        window.location.reload();
        this.render();
    }

    placeOrder () {
        // add item to statuses in store as status "in progress"
    }

    // render a list of item under root element
    render () {
        
        console.log(this.store.cartItems);
        let tbody = this.root.querySelector('tbody');
        // using innerHTML to render a list of table row item under tbody
        var dataset = this.store.cartItems;
        for (var i = 0; i < dataset.length; i++) {
            tbody.innerHTML += `<tr class="item">
            <td>${dataset[i].name}</td>
            <td>${dataset[i].price}</td>
            <td><button class="delete-button" data-index=${i} >Delete</button></td>
        <tr>`
        }
        let deletebutton = document.querySelectorAll('.delete-button');
        deletebutton.forEach(btn => {
            btn.addEventListener('click', () => {
                alert('You are removing an item from cart' )
                this.removeItem(btn.dataset.index);
            });
        });


    
    }

    
}


class CheckoutButton {
    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.onClick = () => this.addItemToCart();
        this.init();
    }

    init () {
        this.root.addEventListener('click', this.onClick);
    }

    destroy () {
    }

    addItemToCart () {
        // hint: you can use `dataset` to access data attributes
        // See passing data from HTML to JavaScript from course note
        let cartItems = this.store.cartItems || [];
        // TODO: replace with actual item
        console.log(this.root.dataset);
        cartItems.push({//push = attaching item to the end of the list
            name: this.root.dataset.name,
            price: this.root.dataset.price
        });
        console.log(cartItems);
        this.store.cartItems = cartItems;
    }
}

class StatusTable {
    // take dom element into JavaScript class to attachment events
    constructor(root, store) {
        this.root = root;
        this.store = store;
        init();
    }

    init () {
        // attach click event listener to table header row on each column
        render();
    }

    destroy () {
        // remove all the events attached from init
    }

    sort (columnName) {
        // after sorting the array of statuses, re render item to update view
        render();
    }

    // render rows of items under table using root.innerHTML
    render () {

    }
}
class Inventory {
        constructor(root, store) {
            this.root = root;
            this.store = store;
            this.init();
        }

        init () {
            this.render();
            
        }

        destroy () {
           let removeInvButtons = document.querySelectorAll('.removebutton');
            for (var i = 0; i < removeInvButtons.length; i++) {
                let btn = removeInvButtons[i];
                btn.removeEventListener('click', () => {
                    let item = this.store.foods[parseInt(btn.dataset.index)];
                    this.removeItem(item);
                });
            }
        }
        removeItem (itemName) {
            if (this.store.foods !== null) {
                var updated_list = [];
                var to_compare = itemName.name;
                for (var i = 0; i < this.store.foods.length; i++) {
                    if (this.store.foods[i].name !== to_compare) {
                        updated_list.push(this.store.foods[i]);
                    }
                }
                this.store.foods = updated_list;
            }
            this.render();
        }
        render () {
            let tbody = this.root.querySelector('tbody');
            tbody.innerHTML = '';
            if (this.store.foods === null) {
                this.store.foods = [];
            }
            for (var i = 0; i < this.store.foods.length; i++) {
                var food_name = this.store.foods[i].name;
                var food_image = this.store.foods[i].image;
                var food_description = this.store.foods[i].description;

                tbody.innerHTML +=
                    `<tr ><td>${food_name}</td>
                        <td><img src=${food_image}></td>
                        <td>${food_description}</td>
                        <td><button class="removebutton" data-index=${i}>Delete</button></td>
                      </tr>`;
            }

            let removeInventoryButtons = document.querySelectorAll('.removebutton');
            for (var i = 0; i < removeInventoryButtons.length; i++) {
                let btn = removeInventoryButtons[i];
                btn.addEventListener('click', () => {
                    let item = this.store.foods[parseInt(btn.dataset.index)];
                    this.removeItem(item);
                });
            }
        }
    }

class Menu {
    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.init();
    }

    init () {
        this.render();
    }

    render () {
        // TODO: render a list of food menu from store using innerHTML
    }
}

class CreateFood {
    

    createFood () {
        Constructor(root,store){
            this.root=root;
            this.store=store;
            this.init();
        }

        init()
        {
            let createFoodB=document.getElementById('.addfood');
            if(createFoodB)
            {
               createFoodB.addEventListener("click", () =>
               {
                this.createFood();
               });
            }
            document.getElementById("").innerHTML='';
        }
        createFood()
        {
            let storeFood=this.store.foods || [];
            var fname=document.getElementById('fname').value;
            var fimage=document.getElementById('imglink').value;
            var fdesc=document.getElementById('desc').value;
            var to_push={name:fname,image:fimage,description:desc};
            var nfood=true;
            for(var i=0;i<storeFoods.length;i++)
            {
            if(to_push.name==storeFoods[i].name)
            {
                nfood=false;
                break;
            }
        }
        if(newfood)
        {
            storeFoods.push(to_push);
            this.store.foods=storeFoods;
            document.getElementById("").innerHTML='';
            document.getElementById("").innerHTML='';
        }
        }

        }
        // will need to do querySelector to find out every single form element
        // to get their values before creating a new food
        // after creating a new food item, add it to store
    }
}

// DOMContentLoaded event will allow us to run the following function when
// everything is ready. Think of the following code will only be executed by
// the end of document
document.addEventListener('DOMContentLoaded', () => {//entry point for a function
    // use querySelector to find the table element (preferably by id selector)
    let statusTable = document.querySelector('');
    // // use querySelector to find the cart element (preferably by id selector)
    //console.log('Entry Point');
    let cart = document.querySelector('.cart-table');//class name in order html table name
    let checkoutButtons = document.querySelectorAll('.checkout-button');//class name 
    console.log(cart);
    console.log(checkoutButtons);

    let createFood=document.querySelector('.my_form');
    let inventory=document.querySelector('.inventorytab');
    let menu=document.querySelector('.table1');
    let inventory=document.querySelectorAll

    let store = new Store(window.localStorage);//store variable
    if (statustable) {
       new StatusTable(table, store);
    // }
    if (cart) {
        new Cart(cart, store);
    }
    if (checkoutButtons && checkoutButtons.length) {
        for (var i = 0; i < checkoutButtons.length; i ++) {
            new CheckoutButton(checkoutButtons[i], store);
        }
    }
    if(createFood)
    {
        new CreateFood(createFood, store);
    }
    if(inventory)
    {
        new Inventory(inventory, store);
    }

});