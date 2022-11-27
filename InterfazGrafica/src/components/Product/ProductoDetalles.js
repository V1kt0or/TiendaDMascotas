import React from 'react'
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
    faComment,
    faShoppingBasket,
    faStar,
    faLock,
    faTruck,
    faCheck,
} from "@fortawesome/free-solid-svg-icons";
import { Link } from 'react-router-dom';

const ProductoDetalles = () => {
    return (
        <section className="padding-y bg-white shadow-sm">
            <div className="container">
                <div className="row">
                    <aside className="col-lg-5">
                        <article className="gallery-wrap">
                            <a href="#" className="img-big-wrap">
                                <img alt="" className="rounded" />
                            </a>
                        </article>
                    </aside>
                    <div className="col-lg-4">
                        <article>
                            <p className="title h4 mb-1">
                                Titulo del Producto
                            </p>
                            <p className="text-success">
                                <FontAwesomeIcon icon={faCheck} /> Estado Disponibilidad
                            </p>
                            <hr />
                            <ul className="list-dots mb-4">
                                <li>Detalles del Producto</li>
                            </ul>
                        </article>
                    </div>
                    <aside className="col-lg-3">
                        <div className="card shadow-sm">
                            <div className="card-body">
                                <div className="mb-3">
                                    <var className="price h5">Precio del producto</var>
                                    <span className="text-muted"> /por unidad</span>
                                </div>
                                <div className="mb-4">
                                    <Link to="/" className="btn btn-primary w-100 mb-2">
                                        Añadir al Carrito
                                    </Link>
                                    <Link to="/carrito" className="btn btn-light w-100 mb-2">
                                        Visualizar mi Carrito
                                    </Link>
                                </div>
                                <ul className="list-icon">
                                    <li>
                                        <FontAwesomeIcon icon={faTruck} /> Envío al todo el país
                                    </li>
                                    <li>
                                        <FontAwesomeIcon icon={faLock} /> Pago Seguro
                                    </li>
                                    <li>
                                        <FontAwesomeIcon icon={faStar} /> Garantía total de 6 meses
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </aside>
                </div>
            </div>
        </section>
    )
}

export default ProductoDetalles