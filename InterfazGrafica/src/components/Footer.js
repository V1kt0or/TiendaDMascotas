import React from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
    faFacebook,
    faInstagram,
    faYoutube,
    faTwitter
} from "@fortawesome/free-brands-svg-icons";
import { faDog } from "@fortawesome/free-solid-svg-icons";
import { Routes, Route, useNavigate } from 'react-router-dom';

function Footer() {
    const navigate = useNavigate()

    return (
        <footer
            className="section-footer bg-white border-top p-3"
            style={{
                marginTop: "2rem",
            }}
        >
            <div className="container">
                <section className="footer-main py-5">
                    <div className="row">
                        <aside className="col-md-12 col-lg-3 col-xl-3">
                            <article className="me-lg-4">
                                <FontAwesomeIcon className="logo-footer" icon={faDog} />

                                <p className="mt-3">
                                    <br />
                                </p>
                            </article>
                        </aside>
                        <aside className="col-6 col-md-3 col-lg-2 col-xl-2">
                            <h6 className="title">Categorías</h6>
                            <ul className="list-menu mb-3">
                                <li>
                                    <a className="list-item" onClick={() => {
                                        navigate('/alimentos')
                                    }}>Alimentos</a>
                                </li>
                                <li>
                                    <a className="list-item" onClick={() => {
                                        navigate('/hogar')
                                    }}>Accesorios para el hogar</a>
                                </li>
                                <li>
                                    <a className="list-item" onClick={() => {
                                        navigate('/exteriores')
                                    }}>Accesorios para el exterior</a>
                                </li>
                                <li>
                                    <a className="list-item" onClick={() => {
                                        navigate('/higiene-bienestar')
                                    }}>Higiene y Bienestar</a>
                                </li>
                                <li>
                                    <a className="list-item" onClick={() => {
                                        navigate('/juguetes')
                                    }}>Juguetes</a>
                                </li>
                            </ul>
                        </aside>
                        <aside className="col-6 col-md-3 col-lg-2 col-xl-2">
                            <h6 className="title"></h6>
                            <ul className="list-menu mb-3">
                                <li>
                                    <a href="/"></a>
                                </li>
                                <li>
                                    <a href="/"></a>
                                </li>
                                <li>
                                    <a href="/"></a>
                                </li>
                            </ul>
                        </aside>
                        <aside className="col-6 col-md-3 col-lg-2 col-xl-2">
                            <h6 className="title"></h6>
                            <ul className="list-menu mb-3">
                                <li>
                                    <a href="/"></a>
                                </li>
                                <li>
                                    <a href="/"></a>
                                </li>
                                <li>
                                    <a href="/"></a>
                                </li>
                            </ul>
                        </aside>
                        <aside className="col-6 col-md-3 col-lg-3 col-xl-3">
                            <h6 className="title">Contáctanos</h6>
                            <p className="h5 mb-0">(0800) Diosito</p>
                            <small className="text-muted">
                                (Horario de Atención: 8am a 10pm)
                            </small>
                            <div className="mt-3">
                                <a
                                    className="btn btn-icon btn-light"
                                    title="Facebook"
                                    target="_blank"
                                    href="/"
                                >
                                    <FontAwesomeIcon icon={faFacebook} />
                                </a>
                                <a
                                    className="btn btn-icon btn-light"
                                    title="Instagram"
                                    target="_blank"
                                    href="/"
                                >
                                    <FontAwesomeIcon icon={faInstagram} />
                                </a>
                                <a
                                    className="btn btn-icon btn-light"
                                    title="Youtube"
                                    target="_blank"
                                    href="/"
                                >
                                    <FontAwesomeIcon icon={faYoutube} />
                                </a>
                                <a
                                    className="btn btn-icon btn-light"
                                    title="Twitter"
                                    target="_blank"
                                    href="/"
                                >
                                    <FontAwesomeIcon icon={faTwitter} />
                                </a>
                            </div>
                        </aside>
                    </div>
                </section>
            </div>
        </footer>
    );
}

export default Footer;
