# 💱 Conversor de Moedas

Aplicativo Android desenvolvido em **Kotlin** para realizar conversões de valores de moedas estrangeiras para **Real (BRL)** utilizando cotações obtidas por meio de uma API.

O projeto foi desenvolvido com o objetivo de praticar conceitos de **desenvolvimento Android, consumo de APIs REST, Retrofit, Gson, Kotlin e construção de interfaces utilizando XML e Material Design**.

---

## 📱 Sobre o projeto

O **Conversor de Moedas** é um aplicativo Android simples e intuitivo que permite ao usuário informar um valor, selecionar uma moeda estrangeira e realizar sua conversão para **Real Brasileiro (BRL)**.

As cotações são obtidas de forma dinâmica por meio de uma API de consulta financeira, permitindo que o aplicativo utilize valores atualizados no momento da consulta.

O aplicativo possui uma interface desenvolvida pensando em simplicidade e facilidade de utilização, permitindo que o usuário realize uma conversão de maneira rápida.

---

## 🎯 Objetivo

O projeto tem como principal objetivo desenvolver uma aplicação Android capaz de consumir uma API externa e utilizar os dados recebidos para realizar cálculos de conversão de moedas.

Além disso, o projeto permite colocar em prática conhecimentos relacionados a:

- Desenvolvimento Android;
- Linguagem Kotlin;
- Interfaces utilizando XML;
- Material Design;
- Consumo de APIs REST;
- Retrofit;
- Gson;
- Manipulação de objetos JSON;
- Validação de dados;
- Organização de projetos Android;
- Tratamento de erros;
- Diferentes orientações de tela.

---

## ✨ Funcionalidades

- [x] Inserção do valor para conversão;
- [x] Seleção da moeda através de um menu suspenso;
- [x] Conversão de Dólar para Real;
- [x] Conversão de Euro para Real;
- [x] Conversão de Peso Argentino para Real;
- [x] Consulta das cotações através de API;
- [x] Validação do campo de valor;
- [x] Validação de valores numéricos;
- [x] Exibição do resultado da conversão;
- [x] Tratamento de erros durante a consulta da API;
- [x] Interface adaptada para diferentes orientações de tela;
- [x] Interface utilizando componentes do Material Design.

---

## 💰 Moedas disponíveis

Atualmente, o aplicativo trabalha com as seguintes moedas:

| Moeda | Código | Conversão |
|---|---|---|
| 🇺🇸 Dólar | USD | Dólar → Real |
| 🇪🇺 Euro | EUR | Euro → Real |
| 🇦🇷 Peso Argentino | ARS | Peso Argentino → Real |

---

## 🖼️ Interface do aplicativo

A tela principal foi desenvolvida com uma interface simples, moderna e objetiva.

O usuário encontra:

- Título do aplicativo;
- Campo para informar o valor;
- Menu para seleção da moeda;
- Botão **Converter**;
- Área para apresentação do resultado.

### Tela principal

<img width="360" height="800" alt="WhatsApp Image 2026-08-28 at 23 48 14" src="https://github.com/user-attachments/assets/69d29471-5308-4c32-a604-f43662c41be3" />


---

## 🛠️ Tecnologias utilizadas

O projeto foi desenvolvido utilizando as seguintes tecnologias:

| Tecnologia | Utilização |
|---|---|
| **Kotlin** | Linguagem principal do aplicativo |
| **Android Studio** | Ambiente de desenvolvimento |
| **Android SDK** | Desenvolvimento da aplicação Android |
| **XML** | Construção das interfaces |
| **ConstraintLayout** | Organização dos componentes da interface |
| **Material Design** | Componentes e identidade visual |
| **Retrofit** | Consumo da API REST |
| **Gson** | Conversão de JSON para objetos Kotlin |
| **HG Brasil API** | Fornecimento das cotações |

---

## 📦 Principais dependências

O projeto utiliza bibliotecas para facilitar o desenvolvimento e o consumo da API.

### Retrofit

Utilizado para realizar as requisições HTTP e consumir os dados disponibilizados pela API.

```gradle
implementation("com.squareup.retrofit2:retrofit:2.11.0")
