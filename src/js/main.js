const images = [
    {src: "../../img/energia.png", text: "Cumbre Energia Renovable 2025"},
    { src: "../../img/reforestacion.png", text: "Jornada de Reforestación" },
    { src: "../../img/cine.png", text: "Feria de Cine Ambiental" },
    { src: "../../img/mercado.jpg", text: "Mercado de Segunda Mano" },
    { src: "../../img/maraton.jpg", text: "Maratón Ecológico" }
];

let index = 0;

const img = document.getElementById("imagen");
const texto = document.getElementById("texto");
const boton1 = document.getElementById("boton1");
const boton2 = document.getElementById("boton2");

function movimiento() {
    img.src = images[index].src;
    texto.textContent =images[index].text;
}

boton2.addEventListener("click", () => {
    index = (index + 1) %  images.length;
    movimiento();
});

boton1.addEventListener("click", () =>{
    index = (index - 1 + images.length) % images.length;
    movimiento();
})

movimiento();