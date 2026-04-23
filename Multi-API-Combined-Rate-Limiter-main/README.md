# Multi-API Rate Limiter 

A scalable backend system that enforces per-endpoint and global rate limits across multiple APIs to prevent abuse, ensure fair usage, and maintain system stability under high traffic.

## Table of Contents

- [Overview](#overview)
- [Key Features](#key-features)
- [System Design](#system-design)
- [Architecture](#architecture)
- [Rate Limiting Logic](#rate-limiting-logic)
- [Tech Stack](#tech-stack)
- [Getting Started](#getting-started)
- [Example Scenario](#example-scenario)
- [Future Improvements](#future-improvements)
- [Use Cases](#use-cases)
- [Author](#author)

## Overview

This project implements a multi-API rate limiting mechanism that:

- Controls how frequently users can access APIs  
- Applies both endpoint-specific limits and a combined global limit  
- Prevents server overload and abuse scenarios  
- Ensures fair distribution of system resources  

## Key Features

- Per-API Rate Limiting – Define request limits for individual endpoints  
- Global Rate Limiting – Enforce a combined cap across all APIs  
- Sliding Window / Time-Based Tracking – Accurate and efficient request counting  
- Middleware Integration – Real-time request validation before processing  
- HTTP 429 Handling – Returns proper response when limits are exceeded  
- Scalable and Configurable Design – Easily extendable to new APIs  

## System Design

### Request Flow
Client Request
↓
Rate Limiter Middleware
↓
Check:

API-specific limit
Global limit
↓
Decision:
Allow Request → API executes
Block Request → HTTP 429


## Architecture

- Middleware Layer – Intercepts all incoming requests  
- Rate Limiter Engine – Applies limit logic  
- Request Store – Tracks request counts (in-memory, extendable to Redis)  
- API Layer – Handles business logic  

## Rate Limiting Logic

Per Endpoint Limit:
/login → 50 requests/min
/payment → 20 requests/min


Decision Rule:
If (API limit exceeded OR Global limit exceeded)
→ Block request
Else
→ Allow request


## Tech Stack

- Backend: Node.js / Express  
- Language: JavaScript  
- Concepts: Rate Limiting, Middleware, System Design  
- Algorithms: Sliding Window / Time-based Counters  

## Getting Started

Clone the repository:

```bash
git clone https://github.com/klshh/Multi-API-Combined-Rate-Limiter.git
cd Multi-API-Combined-Rate-Limiter

Install dependencies:
npm install

Run the server:
npm start

Test the APIs:
GET /api/login
GET /api/payment

```


## Example Scenario 
| API     | Limit | Requests Made | Status  |
| ------- | ----- | ------------- | ------- |
| login   | 50    | 30            | Allowed |
| payment | 20    | 25            | Blocked |
| global  | 100   | 110           | Blocked |

## Future Improvements

- Integrate Redis for distributed rate limiting  
- Implement Token Bucket algorithm  
- Add API authentication and API keys  
- Perform load testing using JMeter or k6  
- Add monitoring and logging  

## Use Cases

- API Gateways  
- Authentication systems (login/signup)  
- Payment services  
- SaaS platforms  

## Author

Vaibhav Uttamchandani  

- GitHub: https://github.com/Vaibhavuttamchandani  
- LinkedIn: https://www.linkedin.com  

## If you found this useful
Give this repo a ⭐ and feel free to contribute!